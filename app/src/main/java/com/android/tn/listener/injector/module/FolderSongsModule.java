package com.android.tn.listener.injector.module;

import dagger.Module;
import dagger.Provides;
import com.android.tn.listener.mvp.contract.FolderSongsContract;
import com.android.tn.listener.mvp.presenter.FolderSongsPresenter;
import com.android.tn.listener.mvp.usecase.GetFolderSongs;
import com.android.tn.listener.respository.interfaces.Repository;

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
