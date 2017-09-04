package com.android.zj.listener.mvp.contract;

import java.util.List;

import com.android.zj.listener.mvp.model.Artist;
import com.android.zj.listener.mvp.presenter.BasePresenter;
import com.android.zj.listener.mvp.view.BaseView;

/**
 * Created by hefuyi on 2016/11/13.
 */

public interface ArtistContract {

    interface View extends BaseView{

        void showArtists(List<Artist> artists);

        void showEmptyView();
    }

    interface Presenter extends BasePresenter<View>{

        void loadArtists(String action);
    }
}
