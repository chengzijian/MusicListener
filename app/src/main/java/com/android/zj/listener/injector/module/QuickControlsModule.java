package com.android.zj.listener.injector.module;

import dagger.Module;
import dagger.Provides;
import com.android.zj.listener.mvp.contract.QuickControlsContract;
import com.android.zj.listener.mvp.presenter.QuickControlsPresenter;
import com.android.zj.listener.mvp.usecase.GetLyric;
import com.android.zj.listener.respository.interfaces.Repository;

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
