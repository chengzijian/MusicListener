package com.android.tn.listener.mvp.contract;

import android.content.Context;

import java.util.List;

import com.android.tn.listener.mvp.model.Song;
import com.android.tn.listener.mvp.presenter.BasePresenter;
import com.android.tn.listener.mvp.view.BaseView;

/**
 * Created by hefuyi on 2016/12/9.
 */

public interface PlayRankingContract {

    interface View extends BaseView {

        Context getContext();

        void showRanking(List<Song> songList);

        void showEmptyView();
    }

    interface Presenter extends BasePresenter<View> {

        void loadRanking();
    }

}
