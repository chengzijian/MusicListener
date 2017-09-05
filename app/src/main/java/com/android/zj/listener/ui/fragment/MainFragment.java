package com.android.zj.listener.ui.fragment;


import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.afollestad.appthemeengine.ATE;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import com.android.zj.listener.Constants;
import com.android.zj.listener.R;
import com.android.zj.listener.util.ATEUtil;
import com.android.zj.listener.util.DensityUtil;
import com.android.zj.listener.util.PreferencesUtility;

import net.youmi.android.nm.bn.BannerManager;
import net.youmi.android.nm.cm.ErrorCode;
import net.youmi.android.nm.sp.SpotListener;
import net.youmi.android.nm.sp.SpotManager;
import net.youmi.android.nm.vdo.VideoAdManager;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends BackHandledFragment {

    @BindView(R.id.appbar)
    AppBarLayout appBarLayout;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tabs)
    TabLayout tabLayout;
    @BindView(R.id.viewpager)
    ViewPager viewPager;

    private PreferencesUtility mPreferences;
    private String action;

    public static MainFragment newInstance(String action) {
        MainFragment mainFragment = new MainFragment();
        Bundle bundle = new Bundle();
        switch (action) {
            case Constants.NAVIGATE_ALLSONG:
                bundle.putString(Constants.PLAYLIST_TYPE, action);
                break;
            case Constants.NAVIGATE_PLAYLIST_RECENTADD:
                bundle.putString(Constants.PLAYLIST_TYPE, action);
                break;
            case Constants.NAVIGATE_PLAYLIST_RECENTPLAY:
                bundle.putString(Constants.PLAYLIST_TYPE, action);
                break;
            case Constants.NAVIGATE_PLAYLIST_FAVOURATE:
                bundle.putString(Constants.PLAYLIST_TYPE, action);
                break;
            default:
                throw new RuntimeException("wrong action type");
        }
        mainFragment.setArguments(bundle);
        return mainFragment;
    }

    @Override
    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPreferences = PreferencesUtility.getInstance(getActivity());

        if (getArguments() != null) {
            action = getArguments().getString(Constants.PLAYLIST_TYPE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ATE.apply(this, ATEUtil.getATEKey(getActivity()));

        ButterKnife.bind(this, view);

        if (Build.VERSION.SDK_INT < 21 && view.findViewById(R.id.status_bar) != null) {
            view.findViewById(R.id.status_bar).setVisibility(View.GONE);
            int statusBarHeight = DensityUtil.getStatusBarHeight(getContext());
            Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
            toolbar.setPadding(0, statusBarHeight, 0, 0);
            AppBarLayout.LayoutParams params = (AppBarLayout.LayoutParams) toolbar.getLayoutParams();
            params.setScrollFlags(0);
            toolbar.setLayoutParams(params);
        }

        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        final ActionBar ab = ((AppCompatActivity) getActivity()).getSupportActionBar();
        ab.setHomeAsUpIndicator(R.drawable.ic_menu);
        ab.setDisplayHomeAsUpEnabled(true);

        switch (action) {
            case Constants.NAVIGATE_ALLSONG:
                ab.setTitle(R.string.library);
                break;
            case Constants.NAVIGATE_PLAYLIST_RECENTADD:
                ab.setTitle(R.string.recent_add);
                break;
            case Constants.NAVIGATE_PLAYLIST_RECENTPLAY:
                ab.setTitle(R.string.recent_play);
                break;
            case Constants.NAVIGATE_PLAYLIST_FAVOURATE:
                ab.setTitle(R.string.favourate);
                break;
        }

        tabLayout.setupWithViewPager(viewPager);

        if (viewPager != null) {
            setupViewPager(viewPager);
            viewPager.setOffscreenPageLimit(2);
            viewPager.setCurrentItem(mPreferences.getStartPageIndex());
        }

    }

    private void setupViewPager(ViewPager viewPager) {
        Adapter adapter = new Adapter(getChildFragmentManager());
        adapter.addFragment(SongsFragment.newInstance(action), this.getString(R.string.songs));
        adapter.addFragment(ArtistFragment.newInstance(action), this.getString(R.string.artists));
        adapter.addFragment(AlbumFragment.newInstance(action), this.getString(R.string.albums));
        viewPager.setAdapter(adapter);
    }

    @Override
    public void onPause() {
        super.onPause();
        mPreferences.setStartPageIndex(viewPager.getCurrentItem());
        // 插屏广告
        SpotManager.getInstance(getContext()).onPause();
    }

    static class Adapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragments = new ArrayList<>();
        private final List<String> mFragmentTitles = new ArrayList<>();

        public Adapter(FragmentManager fm) {
            super(fm);
        }

        public void addFragment(Fragment fragment, String title) {
            mFragments.add(fragment);
            mFragmentTitles.add(title);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitles.get(position);
        }
    }

    boolean show = false;
    @Override
    public boolean onBackPressed() {
        if (SpotManager.getInstance(getContext()).isSpotShowing()) {
            SpotManager.getInstance(getContext()).hideSpot();
            return true;
        } else if(!SpotManager.getInstance(getContext()).isSpotShowing() && !show){
            show = true;
            setupSpotAd();
            return true;
        }
        return false;
    }

    /**
     * 设置插屏广告
     */
    public void setupSpotAd() {
        // 展示插屏广告
        SpotManager.getInstance(getContext()).showSpot(getContext(), new SpotListener() {

            @Override
            public void onShowSuccess() {
                Log.e("mainLog-", "插屏展示成功");
            }

            @Override
            public void onShowFailed(int errorCode) {
                Log.e("mainLog-", "插屏展示失败");
                switch (errorCode) {
                    case ErrorCode.NON_NETWORK:
                        Log.e("mainLog-", "网络异常");
                        break;
                    case ErrorCode.NON_AD:
                        Log.e("mainLog-", "暂无插屏广告");
                        break;
                    case ErrorCode.RESOURCE_NOT_READY:
                        Log.e("mainLog-", "插屏资源还没准备好");
                        break;
                    case ErrorCode.SHOW_INTERVAL_LIMITED:
                        Log.e("mainLog-", "请勿频繁展示");
                        break;
                    case ErrorCode.WIDGET_NOT_IN_VISIBILITY_STATE:
                        Log.e("mainLog-", "请设置插屏为可见状态");
                        break;
                    default:
                        Log.e("mainLog-", "请稍后再试");
                        break;
                }
            }

            @Override
            public void onSpotClosed() {
                Log.e("mainLog-", "插屏被关闭");
            }

            @Override
            public void onSpotClicked(boolean isWebPage) {
                Log.e("mainLog-", "插屏被点击");
                Log.e("mainLog-", String.format("是否是网页广告？%s", isWebPage ? "是" : "不是"));
            }
        });

    }

    @Override
    public void onStart() {
        super.onStart();
        mBackHandledInterface.setSelectedFragment(this);
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onStop() {
        super.onStop();
        // 插屏广告
        SpotManager.getInstance(getContext()).onStop();
        // 原生视频广告
        VideoAdManager.getInstance(getContext()).onStop();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        // 展示广告条窗口的 onDestroy() 回调方法中调用
        BannerManager.getInstance(getContext()).onDestroy();

        // 退出应用时调用，用于释放资源
        // 如果无法保证应用主界面的 onDestroy() 方法被执行到，请移动以下接口到应用的退出逻辑里面调用

        // 插屏广告（包括普通插屏广告、轮播插屏广告、原生插屏广告）
        SpotManager.getInstance(getContext()).onAppExit();
    }

}
