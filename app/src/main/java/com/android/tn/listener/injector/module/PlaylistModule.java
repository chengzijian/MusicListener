package com.android.tn.listener.injector.module;

import dagger.Module;
import dagger.Provides;
import com.android.tn.listener.mvp.contract.PlaylistContract;
import com.android.tn.listener.mvp.presenter.PlaylistPresenter;
import com.android.tn.listener.mvp.usecase.GetPlaylists;
import com.android.tn.listener.respository.interfaces.Repository;

/**
 * Created by hefuyi on 2016/12/5.
 */
@Module
public class PlaylistModule {

    @Provides
    GetPlaylists getPlaylistUsecase(Repository repository) {
        return new GetPlaylists(repository);
    }

    @Provides
    PlaylistContract.Presenter getPlaylistPresenter(GetPlaylists getPlaylists) {
        return new PlaylistPresenter(getPlaylists);
    }
}
