package com.android.tn.listener.mvp.contract;

import java.util.List;

import com.android.tn.listener.mvp.model.Playlist;
import com.android.tn.listener.mvp.presenter.BasePresenter;
import com.android.tn.listener.mvp.view.BaseView;

/**
 * Created by hefuyi on 2016/12/4.
 */

public interface PlaylistContract {

    interface View extends BaseView {

        void showPlaylist(List<Playlist> playlists);

        void showEmptyView();

    }

    interface Presenter extends BasePresenter<View> {

        void loadPlaylist();
    }
}
