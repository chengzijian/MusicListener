package com.android.zj.listener.injector.component;

import dagger.Component;
import com.android.zj.listener.injector.module.FolderSongsModule;
import com.android.zj.listener.injector.scope.PerActivity;
import com.android.zj.listener.ui.fragment.FolderSongsFragment;

/**
 * Created by hefuyi on 2016/12/12.
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = FolderSongsModule.class)
public interface FolderSongsComponent {

    void inject(FolderSongsFragment folderSongsFragment);
}
