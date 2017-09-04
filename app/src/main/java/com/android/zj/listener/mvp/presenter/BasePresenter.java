package com.android.zj.listener.mvp.presenter;

import com.android.zj.listener.mvp.view.BaseView;

/**
 * Created by hefuyi on 2016/11/7.
 */

public interface BasePresenter<T extends BaseView>{

    void attachView(T view);

    void subscribe();

    void unsubscribe();
}
