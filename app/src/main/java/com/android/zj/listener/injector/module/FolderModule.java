package com.android.zj.listener.injector.module;

import dagger.Module;
import dagger.Provides;
import com.android.zj.listener.mvp.contract.FoldersContract;
import com.android.zj.listener.mvp.presenter.FolderPresenter;
import com.android.zj.listener.mvp.usecase.GetFolders;
import com.android.zj.listener.respository.interfaces.Repository;

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
