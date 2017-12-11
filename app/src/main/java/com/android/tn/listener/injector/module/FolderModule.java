package com.android.tn.listener.injector.module;

import dagger.Module;
import dagger.Provides;
import com.android.tn.listener.mvp.contract.FoldersContract;
import com.android.tn.listener.mvp.presenter.FolderPresenter;
import com.android.tn.listener.mvp.usecase.GetFolders;
import com.android.tn.listener.respository.interfaces.Repository;

/**
 * Created by hefuyi on 2016/12/11.
 */
@Module
public class FolderModule {

    @Provides
    GetFolders getFoldersUsecase(Repository repository) {
        return new GetFolders(repository);
    }

    @Provides
    FoldersContract.Presenter getFoldersPresenter(GetFolders getFolders) {
        return new FolderPresenter(getFolders);
    }
}
