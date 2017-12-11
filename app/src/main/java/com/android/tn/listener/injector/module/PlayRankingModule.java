package com.android.tn.listener.injector.module;

import dagger.Module;
import dagger.Provides;
import com.android.tn.listener.mvp.contract.PlayRankingContract;
import com.android.tn.listener.mvp.presenter.PlayRankingPresenter;
import com.android.tn.listener.mvp.usecase.GetSongs;
import com.android.tn.listener.respository.interfaces.Repository;

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
