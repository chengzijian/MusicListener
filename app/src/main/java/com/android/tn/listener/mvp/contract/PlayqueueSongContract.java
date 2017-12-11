package com.android.tn.listener.mvp.contract;

import android.content.Context;

import java.util.List;

import com.android.tn.listener.mvp.model.Song;
import com.android.tn.listener.mvp.presenter.BasePresenter;
import com.android.tn.listener.mvp.view.BaseView;

/**
 * Created by hefuyi on 2016/12/27.
 */

public interface PlayqueueSongContract {

    interface View extends BaseView{

        Context getContext();

        void showSongs(List<Song> songs);

    }

    interface Presenter extends BasePresenter<View> {

        void loadSongs();
    }
}
