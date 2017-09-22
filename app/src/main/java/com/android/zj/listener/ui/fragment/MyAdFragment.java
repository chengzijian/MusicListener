package com.android.zj.listener.ui.fragment;

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
import com.android.zj.listener.ui.activity.QuitPopAd;
import com.android.zj.listener.util.ATEUtil;
import com.android.zj.listener.util.DensityUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.waps.AppConnect;
import cn.waps.AppListener;

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

    @BindView(R.id.AdLinearLayout)
    LinearLayout bannerLayout;

    @BindView(R.id.miniAdLinearLayout)
    LinearLayout miniAdLinearLayout;

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
        getActivity().findViewById(R.id.quickcontrols_container).setVisibility(View.GONE);

//        初始化(预先加载)广告数据:
        AppConnect.getInstance(getActivity()).initAdInfo();

        // 预加载插屏广告内容（仅在使用到插屏广告的情况，才需要添加）
        AppConnect.getInstance(getActivity()).initPopAd(getContext());

        // 设置为true表示可通过back键关闭，不调用该句代码则使用默认值false
//         AppConnect.getInstance(getActivity()).setPopAdBack(true);

        // 互动广告调用方式
        AppConnect.getInstance(getActivity()).showBannerAd(getActivity(), bannerLayout);

        // 迷你广告调用方式
        // AppConnect.getInstance(this).setAdBackColor(Color.argb(50, 120, 240,
        // 120));//设置迷你广告背景颜色
        // AppConnect.getInstance(this).setAdForeColor(Color.YELLOW);//设置迷你广告文字颜色
        AppConnect.getInstance(getActivity()).showMiniAd(getActivity(), miniAdLinearLayout, 10);// 10秒刷新一次

    }

    @OnClick(R.id.button1)
    public void setupSpotAd1() {
        // 调用退屏广告
        //AppConnect.getInstance(getActivity()).getAdInfo();//每次调用将自劢轮换广告
        // 调用退屏广告
        QuitPopAd.getInstance().show(getActivity());
    }

    /**
     * 设置插屏广告
     */
    @OnClick(R.id.button2)
    public void setupSpotAd() {
        if(AppConnect.getInstance(getActivity()).hasPopAd(getActivity())){

        }
        // 设置插屏广告无数据时的回调监听（该方法必须在showPopAd之前调用）
        AppConnect.getInstance(getContext()).setPopAdNoDataListener(new AppListener() {

            @Override
            public void onPopNoData() {
                Log.i("debug", "插屏广告暂无可用数据");
            }

        });
        // 显示插屏广告
        AppConnect.getInstance(getContext()).showPopAd(getContext());
    }

    @OnClick(R.id.button4)
    public void onClickExitApp() {
        try {
            getActivity().finish();
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
