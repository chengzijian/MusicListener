package com.android.zj.listener.injector.module;

import dagger.Module;
import dagger.Provides;
import com.android.zj.listener.mvp.contract.PlayRankingContract;
import com.android.zj.listener.mvp.presenter.PlayRankingPresenter;
import com.android.zj.listener.mvp.usecase.GetSongs;
import com.android.zj.listener.respository.interfaces.Repository;

/**
 * Created by hefuyi on 2016/12/9.
 */
@Module
public class PlayRankingModule {

    @Provides
    GetSongs getSongsUsecase(Repository repository) {
        return new GetSongs(repository);
    }

    @Provides
    PlayRankingContract.Presenter getPlayRankingPresenter(GetSongs getSongs) {
        return new PlayRankingPresenter(getSongs);
    }
}
