package com.android.zj.listener.mvp.contract;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

import java.util.List;

import com.android.zj.listener.mvp.model.Song;
import com.android.zj.listener.mvp.presenter.BasePresenter;
import com.android.zj.listener.mvp.view.BaseView;

/**
 * Created by hefuyi on 2016/12/3.
 */

public interface AlbumDetailContract {

    interface View extends BaseView{

        Context getContext();

        void showAlbumSongs(List<Song> songList);

        void showAlbumArt(Drawable albumArt);

        void showAlbumArt(Bitmap bitmap);
    }

    interface Presenter extends BasePresenter<View> {

        void subscribe(long albumID);

        void loadAlbumSongs(long albumID);

        void loadAlbumArt(long albumID);
    }
}
