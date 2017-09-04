package com.android.zj.listener.injector.module;

import dagger.Module;
import dagger.Provides;
import com.android.zj.listener.mvp.contract.FolderSongsContract;
import com.android.zj.listener.mvp.presenter.FolderSongsPresenter;
import com.android.zj.listener.mvp.usecase.GetFolderSongs;
import com.android.zj.listener.respository.interfaces.Repository;

/**
 * Created by hefuyi on 2016/12/12.
 */
@Module
public class FolderSongsModule {

    @Provides
    GetFolderSongs getFolderSongsUsecase(Repository repository) {
        return new GetFolderSongs(repository);
    }

    @Provides
    FolderSongsContract.Presenter getFolderSongsPresenter(GetFolderSongs getFolderSongs) {
        return new FolderSongsPresenter(getFolderSongs);
    }
}
