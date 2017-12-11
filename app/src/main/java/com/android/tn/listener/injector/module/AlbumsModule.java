package com.android.tn.listener.injector.module;

import dagger.Module;
import dagger.Provides;
import com.android.tn.listener.mvp.contract.AlbumsContract;
import com.android.tn.listener.mvp.presenter.AlbumsPresenter;
import com.android.tn.listener.mvp.usecase.GetAlbums;
import com.android.tn.listener.respository.interfaces.Repository;

/**
 * Created by hefuyi on 2016/11/12.
 */
@Module
public class AlbumsModule {

    @Provides
    AlbumsContract.Presenter getAlbumsPresenter(GetAlbums getAlbums) {
        return new AlbumsPresenter(getAlbums);
    }

    @Provides
    GetAlbums getAlbumsUsecase(Repository repository) {
        return new GetAlbums(repository);
    }
}
