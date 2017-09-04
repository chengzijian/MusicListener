package com.android.zj.listener.injector.component;

import dagger.Component;
import com.android.zj.listener.injector.module.FolderModule;
import com.android.zj.listener.injector.scope.PerActivity;
import com.android.zj.listener.ui.fragment.FoldersFragment;

/**
 * Created by hefuyi on 2016/12/11.
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = FolderModule.class)
public interface FoldersComponent {

    void inject(FoldersFragment foldersFragment);
}
