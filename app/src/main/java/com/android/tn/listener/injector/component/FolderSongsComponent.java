package com.android.tn.listener.injector.component;

import dagger.Component;
import com.android.tn.listener.injector.module.FolderSongsModule;
import com.android.tn.listener.injector.scope.PerActivity;
import com.android.tn.listener.ui.fragment.FolderSongsFragment;

/**
 * Created by hefuyi on 2016/12/12.
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = FolderSongsModule.class)
public interface FolderSongsComponent {

    void inject(FolderSongsFragment folderSongsFragment);
}
