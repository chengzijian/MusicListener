package com.android.tn.listener.injector.module;

import dagger.Module;
import dagger.Provides;
import com.android.tn.listener.mvp.contract.AlbumDetailContract;
import com.android.tn.listener.mvp.presenter.AlbumDetailPresenter;
import com.android.tn.listener.mvp.usecase.GetAlbumSongs;
import com.android.tn.listener.respository.interfaces.Repository;

/**
 * Created by hefuyi on 2016/12/3.
 */
@Module
public class AlbumSongsModel {

    @Provides
    GetAlbumSongs getAlbumSongUsecase(Repository repository) {
        return new GetAlbumSongs(repository);
    }

    @Provides
    AlbumDetailContract.Presenter getAlbumDetailPresenter(GetAlbumSongs getAlbumSongs) {
        return new AlbumDetailPresenter(getAlbumSongs);
    }
}
