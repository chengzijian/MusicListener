package com.android.zj.listener.injector.module;

import dagger.Module;
import dagger.Provides;
import com.android.zj.listener.mvp.contract.SongsContract;
import com.android.zj.listener.mvp.presenter.SongsPresenter;
import com.android.zj.listener.mvp.usecase.GetSongs;
import com.android.zj.listener.respository.interfaces.Repository;

/**
 * Created by hefuyi on 2016/11/12.
 */
@Module
public class SongsModule {

    @Provides
    SongsContract.Presenter getSongsPresenter(GetSongs getSongs) {
        return new SongsPresenter(getSongs);
    }

    @Provides
    GetSongs getSongsUsecase(Repository repository) {
        return new GetSongs(repository);
    }
}
