package com.android.tn.listener.injector.module;

import dagger.Module;
import dagger.Provides;
import com.android.tn.listener.mvp.contract.ArtistDetailContract;
import com.android.tn.listener.mvp.presenter.ArtistDetailPresenter;
import com.android.tn.listener.mvp.usecase.GetArtistInfo;
import com.android.tn.listener.respository.interfaces.Repository;

/**
 * Created by hefuyi on 2016/11/13.
 */
@Module
public class ArtistInfoModule {

    @Provides
    GetArtistInfo getArtistInfoUsecase(Repository repository) {
        return new GetArtistInfo(repository);
    }

    @Provides
    ArtistDetailContract.Presenter getArtistDetailPresenter() {
        return new ArtistDetailPresenter();
    }
}
