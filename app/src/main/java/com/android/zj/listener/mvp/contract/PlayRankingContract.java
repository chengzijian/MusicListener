package com.android.zj.listener.mvp.contract;

import android.content.Context;

import java.util.List;

import com.android.zj.listener.mvp.model.Song;
import com.android.zj.listener.mvp.presenter.BasePresenter;
import com.android.zj.listener.mvp.view.BaseView;

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
