package com.android.tn.listener.mvp.contract;

import java.util.List;

import com.android.tn.listener.mvp.presenter.BasePresenter;
import com.android.tn.listener.mvp.view.BaseView;

/**
 * Created by hefuyi on 2017/1/3.
 */

public interface SearchContract {

    interface View extends BaseView {

        void showSearchResult(List<Object> list);

        void showEmptyView();
    }

    interface Presenter extends BasePresenter<View> {

        void search(String queryString);
    }

}
