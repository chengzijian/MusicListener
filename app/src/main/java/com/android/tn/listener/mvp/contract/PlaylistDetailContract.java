package com.android.tn.listener.mvp.contract;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

import java.util.List;

import com.android.tn.listener.mvp.model.Song;
import com.android.tn.listener.mvp.presenter.BasePresenter;
import com.android.tn.listener.mvp.view.BaseView;

/**
 * Created by hefuyi on 2016/12/5.
 */

public interface PlaylistDetailContract {

    interface View extends BaseView{

        Context getContext();

        void showPlaylistSongs(List<Song> songList);

        void showPlaylistArt(Drawable playlistArt);

        void showPlaylistArt(Bitmap bitmap);
    }

    interface Presenter extends BasePresenter<View> {

        void loadPlaylistSongs(long playlistID);

        void loadPlaylistArt(long firstAlbumID);
    }
}
