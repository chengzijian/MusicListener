package com.android.zj.listener.injector.module;

import dagger.Module;
import dagger.Provides;
import com.android.zj.listener.mvp.contract.AlbumDetailContract;
import com.android.zj.listener.mvp.presenter.AlbumDetailPresenter;
import com.android.zj.listener.mvp.usecase.GetAlbumSongs;
import com.android.zj.listener.respository.interfaces.Repository;

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
