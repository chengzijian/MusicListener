package com.android.zj.listener.mvp.contract;

import java.util.List;

import com.android.zj.listener.mvp.model.Song;
import com.android.zj.listener.mvp.presenter.BasePresenter;
import com.android.zj.listener.mvp.view.BaseView;

/**
 * Created by hefuyi on 2016/11/25.
 */

public interface ArtistSongContract {

    interface View extends BaseView {

        void showSongs(List<Song> songList);
    }

    interface Presenter extends BasePresenter<View> {

        void subscribe(long artistID);

        void loadSongs(long artistID);
    }

}
