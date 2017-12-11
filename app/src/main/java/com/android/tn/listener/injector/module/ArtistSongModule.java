package com.android.tn.listener.injector.module;

import dagger.Module;
import dagger.Provides;
import com.android.tn.listener.mvp.contract.ArtistSongContract;
import com.android.tn.listener.mvp.presenter.ArtistSongPresenter;
import com.android.tn.listener.mvp.usecase.GetArtistSongs;
import com.android.tn.listener.respository.interfaces.Repository;

/**
 * Created by hefuyi on 2016/11/25.
 */
@Module
public class ArtistSongModule {

    @Provides
    GetArtistSongs getArtistSongsUsecase(Repository repository) {
        return new GetArtistSongs(repository);
    }

    @Provides
    ArtistSongContract.Presenter getArtistSongPresenter(GetArtistSongs getArtistSongs) {
        return new ArtistSongPresenter(getArtistSongs);
    }
}
