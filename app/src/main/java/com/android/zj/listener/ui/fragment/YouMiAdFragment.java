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
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.afollestad.appthemeengine.ATE;
import com.android.zj.listener.R;
import com.android.zj.listener.util.ATEUtil;
import com.android.zj.listener.util.DensityUtil;

import net.youmi.android.nm.bn.BannerManager;
import net.youmi.android.nm.bn.BannerViewListener;
import net.youmi.android.nm.cm.ErrorCode;
import net.youmi.android.nm.sp.SpotListener;
import net.youmi.android.nm.sp.SpotManager;
import net.youmi.android.nm.vdo.VideoAdManager;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class YouMiAdFragment extends BackHandledFragment {

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

    public static YouMiAdFragment newInstance() {
        YouMiAdFragment mainFragment = new YouMiAdFragment();
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
        ab.setTitle("有米广告");
        getActivity().findViewById(R.id.quickcontrols_container).setVisibility(View.GONE);
    }

    /**
     * 设置轮播插屏广告
     */
    @OnClick(R.id.button1)
    public void setupSlideableSpotAd() {
        // 展示轮播插屏广告
        SpotManager.getInstance(mContext)
                .showSlideableSpot(mContext, new SpotListener() {

                    @Override
                    public void onShowSuccess() {
                        Log.e("", "轮播插屏展示成功");
                    }

                    @Override
                    public void onShowFailed(int errorCode) {
                        Log.e("", "轮播插屏展示失败");
                        switch (errorCode) {
                            case ErrorCode.NON_NETWORK:
                                Log.e("", "网络异常");
                                break;
                            case ErrorCode.NON_AD:
                                Log.e("", "暂无轮播插屏广告");
                                break;
                            case ErrorCode.RESOURCE_NOT_READY:
                                Log.e("", "轮播插屏资源还没准备好");
                                break;
                            case ErrorCode.SHOW_INTERVAL_LIMITED:
                                Log.e("", "请勿频繁展示");
                                break;
                            case ErrorCode.WIDGET_NOT_IN_VISIBILITY_STATE:
                                Log.e("", "请设置插屏为可见状态");
                                break;
                            default:
                                Log.e("", "请稍后再试");
                                break;
                        }
                    }

                    @Override
                    public void onSpotClosed() {
                        Log.e("", "轮播插屏被关闭");
                    }

                    @Override
                    public void onSpotClicked(boolean isWebPage) {
                        Log.e("", "轮播插屏被点击");
                        Log.e("", String.format("是否是网页广告？%s", isWebPage ? "是" : "不是"));
                    }
                });

    }
    
    /**
     * 设置插屏广告
     */
    @OnClick(R.id.button2)
    public void setupSpotAd() {
        // 展示插屏广告
        SpotManager.getInstance(mContext).showSpot(mContext, new SpotListener() {

            @Override
            public void onShowSuccess() {
                Log.i("", "插屏展示成功");
            }

            @Override
            public void onShowFailed(int errorCode) {
                Log.e("", "插屏展示失败");
                switch (errorCode) {
                    case ErrorCode.NON_NETWORK:
                        Log.e("", "网络异常");
                        break;
                    case ErrorCode.NON_AD:
                        Log.e("", "暂无插屏广告");
                        break;
                    case ErrorCode.RESOURCE_NOT_READY:
                        Log.e("", "插屏资源还没准备好");
                        break;
                    case ErrorCode.SHOW_INTERVAL_LIMITED:
                        Log.e("", "请勿频繁展示");
                        break;
                    case ErrorCode.WIDGET_NOT_IN_VISIBILITY_STATE:
                        Log.e("", "请设置插屏为可见状态");
                        break;
                    default:
                        Log.e("", "请稍后再试");
                        break;
                }
            }

            @Override
            public void onSpotClosed() {
                Log.e("", "插屏被关闭");
            }

            @Override
            public void onSpotClicked(boolean isWebPage) {
                Log.e("", "插屏被点击");
                Log.i("", String.format("是否是网页广告？%s", isWebPage ? "是" : "不是"));
            }
        });

    }

    @OnClick(R.id.button3)
    public void setupBannerAd() {
        // 获取广告条
        final View bannerView = BannerManager.getInstance(mContext)
                .getBannerView(mContext, new BannerViewListener() {

                    @Override
                    public void onRequestSuccess() {
                        Log.d("YouMi", "请求广告条成功");

                    }

                    @Override
                    public void onSwitchBanner() {
                        Log.d("YouMi", "广告条切换");
                    }

                    @Override
                    public void onRequestFailed() {
                        Log.d("YouMi", "请求广告条失败");
                    }
                });
        // 添加广告条到容器中
        bannerLayout.addView(bannerView);
    }
    
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
        // 插屏广告
        SpotManager.getInstance(mContext).onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
        // 插屏广告
        SpotManager.getInstance(mContext).onStop();
        // 原生视频广告
        VideoAdManager.getInstance(mContext).onStop();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        // 展示广告条窗口的 onDestroy() 回调方法中调用
        BannerManager.getInstance(mContext).onDestroy();

        // 退出应用时调用，用于释放资源
        // 如果无法保证应用主界面的 onDestroy() 方法被执行到，请移动以下接口到应用的退出逻辑里面调用

        // 插屏广告（包括普通插屏广告、轮播插屏广告、原生插屏广告）
        SpotManager.getInstance(mContext).onAppExit();
    }

    @Override
    public boolean onBackPressed() {
        // 点击后退关闭插屏广告
        if (SpotManager.getInstance(mContext).isSpotShowing()) {
            SpotManager.getInstance(mContext).hideSpot();
        } else if (SpotManager.getInstance(mContext).isSlideableSpotShowing()) {
            // 点击后退关闭轮播插屏广告
            SpotManager.getInstance(mContext).hideSlideableSpot();
        }
        return true;
    }
}
