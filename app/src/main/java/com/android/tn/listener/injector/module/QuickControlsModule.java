package com.android.tn.listener.injector.module;

import dagger.Module;
import dagger.Provides;
import com.android.tn.listener.mvp.contract.QuickControlsContract;
import com.android.tn.listener.mvp.presenter.QuickControlsPresenter;
import com.android.tn.listener.mvp.usecase.GetLyric;
import com.android.tn.listener.respository.interfaces.Repository;

/**
 * Created by hefuyi on 2016/11/7.
 */
@Module
public class QuickControlsModule {

    @Provides
    QuickControlsContract.Presenter getQuickControlsPresenter(GetLyric getLyric) {
        return new QuickControlsPresenter(getLyric);
    }

    @Provides
    GetLyric getLyricUsecase(Repository repository) {
        return new GetLyric(repository);
    }

}
