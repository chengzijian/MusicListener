package com.android.zj.listener.injector.module;

import dagger.Module;
import dagger.Provides;
import com.android.zj.listener.mvp.contract.ArtistContract;
import com.android.zj.listener.mvp.presenter.ArtistPresenter;
import com.android.zj.listener.mvp.usecase.GetArtists;
import com.android.zj.listener.respository.interfaces.Repository;

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
