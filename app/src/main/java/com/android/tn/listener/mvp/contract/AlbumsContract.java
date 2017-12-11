package com.android.tn.listener.mvp.contract;

import java.util.List;

import com.android.tn.listener.mvp.model.Album;
import com.android.tn.listener.mvp.presenter.BasePresenter;
import com.android.tn.listener.mvp.view.BaseView;

/**
 * Created by hefuyi on 2016/11/12.
 */

public interface AlbumsContract {

    interface View extends BaseView{

        void showAlbums(List<Album> albumList);

        void showEmptyView();
    }

    interface Presenter extends BasePresenter<View> {

        void loadAlbums(String action);

    }
}
