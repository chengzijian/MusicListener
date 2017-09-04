package com.android.zj.listener.injector.module;

import dagger.Module;
import dagger.Provides;
import com.android.zj.listener.mvp.contract.PlayqueueSongContract;
import com.android.zj.listener.mvp.presenter.PlayqueueSongPresenter;
import com.android.zj.listener.mvp.usecase.GetSongs;
import com.android.zj.listener.respository.interfaces.Repository;

/**
 * Created by hefuyi on 2016/12/27.
 */
@Module
public class PlayqueueSongModule {

    @Provides
    GetSongs getSongsUsecase(Repository repository) {
        return new GetSongs(repository);
    }

    @Provides
    PlayqueueSongContract.Presenter getPlayqueueSongUsecase(GetSongs getSongs) {
        return new PlayqueueSongPresenter(getSongs);
    }
}
