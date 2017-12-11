package com.android.tn.listener.injector.module;

import dagger.Module;
import dagger.Provides;
import com.android.tn.listener.mvp.contract.ArtistContract;
import com.android.tn.listener.mvp.presenter.ArtistPresenter;
import com.android.tn.listener.mvp.usecase.GetArtists;
import com.android.tn.listener.respository.interfaces.Repository;

/**
 * Created by hefuyi on 2016/11/13.
 */
@Module
public class ArtistsModule {

    @Provides
    ArtistContract.Presenter getArtistPresenter(GetArtists getArtists) {
        return new ArtistPresenter(getArtists);
    }

    @Provides
    GetArtists getArtistsUsecase(Repository repository) {
        return new GetArtists(repository);
    }
}
