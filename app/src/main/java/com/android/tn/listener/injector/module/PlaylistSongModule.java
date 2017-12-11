package com.android.tn.listener.injector.module;

import dagger.Module;
import dagger.Provides;
import com.android.tn.listener.mvp.contract.PlaylistDetailContract;
import com.android.tn.listener.mvp.presenter.PlaylistDetailPresenter;
import com.android.tn.listener.mvp.usecase.GetPlaylistSongs;
import com.android.tn.listener.respository.interfaces.Repository;

/**
 * Created by hefuyi on 2016/12/6.
 */
@Module
public class PlaylistSongModule {

    @Provides
    GetPlaylistSongs getPlaylistSongsUsecase(Repository repository) {
        return new GetPlaylistSongs(repository);
    }

    @Provides
    PlaylistDetailContract.Presenter getPlaylistDetailPresenter(GetPlaylistSongs getPlaylistSongs) {
        return new PlaylistDetailPresenter(getPlaylistSongs);
    }
}
