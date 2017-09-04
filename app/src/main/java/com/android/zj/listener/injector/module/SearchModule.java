package com.android.zj.listener.injector.module;

import dagger.Module;
import dagger.Provides;
import com.android.zj.listener.mvp.contract.SearchContract;
import com.android.zj.listener.mvp.presenter.SearchPresenter;
import com.android.zj.listener.mvp.usecase.GetSearchResult;
import com.android.zj.listener.respository.interfaces.Repository;

/**
 * Created by hefuyi on 2017/1/3.
 */
@Module
public class SearchModule {

    @Provides
    SearchContract.Presenter getSearchPresenter(GetSearchResult getSearchResult) {
        return new SearchPresenter(getSearchResult);
    }

    @Provides
    GetSearchResult getSearchResultUsecase(Repository repository) {
        return new GetSearchResult(repository);
    }
}
