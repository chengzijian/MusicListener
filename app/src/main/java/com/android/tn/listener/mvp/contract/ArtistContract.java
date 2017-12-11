package com.android.tn.listener.mvp.contract;

import java.util.List;

import com.android.tn.listener.mvp.model.Artist;
import com.android.tn.listener.mvp.presenter.BasePresenter;
import com.android.tn.listener.mvp.view.BaseView;

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
