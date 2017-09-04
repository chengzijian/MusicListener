package com.android.zj.listener.mvp.contract;

import java.util.List;

import com.android.zj.listener.mvp.model.Song;
import com.android.zj.listener.mvp.presenter.BasePresenter;
import com.android.zj.listener.mvp.view.BaseView;

/**
 * Created by hefuyi on 2016/11/12.
 */

public interface SongsContract {

    interface View extends BaseView {

        void showSongs(List<Song> songList);

        void showEmptyView();
    }

    interface Presenter extends BasePresenter<View> {

        void loadSongs(String action);
    }
}
