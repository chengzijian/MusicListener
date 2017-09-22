package com.android.zj.listener.ui.fragment;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.afollestad.appthemeengine.ATE;
import com.android.zj.listener.R;
import com.android.zj.listener.util.ATEUtil;
import com.android.zj.listener.util.DensityUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyAdFragment extends BackHandledFragment {

//    Intent it = new Intent();
//    it.setComponent(new ComponentName("com.android.zj.listener", "com.android.zj.listener.ui.activity.MainActivity")); //包名和类名
//    it.putExtra("show_tag", "value"); //传一些参数
//    startActivity(it);

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.ll_main_banner)
    LinearLayout bannerLayout;
    
    private ActivityManager activityMgr;
    protected Context mContext;

    public static MyAdFragment newInstance() {
        MyAdFragment mainFragment = new MyAdFragment();
        Bundle bundle = new Bundle();
        mainFragment.setArguments(bundle);
        return mainFragment;
    }

    @Override
    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMgr = (ActivityManager) getContext().getSystemService(Context.ACTIVITY_SERVICE);
        mContext = getContext();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_ad_view, container, false);
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
        ActionBar ab = ((AppCompatActivity) getActivity()).getSupportActionBar();
        ab.setTitle("星火传媒");
        getActivity().findViewById(R.id.quickcontrols_container).setVisibility(View.GONE);

    }

    /**
     * 设置轮播插屏广告
     */
    @OnClick(R.id.button1)
    public void setupSlideableSpotAd() {
    }
    
    /**
     * 设置插屏广告
     */
    @OnClick(R.id.button2)
    public void setupSpotAd() {}

    public void setupBannerAd() {}
    
    @OnClick(R.id.button4)
    public void onClickExitApp() {
        try {
            getActivity().finish();
            activityMgr.killBackgroundProcesses(getContext().getPackageName());
            System.exit(0);
        } catch (Exception e) {
            ;
        }
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
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public boolean onBackPressed() {
        return false;
    }
}
