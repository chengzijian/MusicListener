package com.android.tn.listener.injector.component;

import dagger.Component;
import com.android.tn.listener.injector.module.FolderModule;
import com.android.tn.listener.injector.scope.PerActivity;
import com.android.tn.listener.ui.fragment.FoldersFragment;

/**
 * Created by hefuyi on 2016/12/11.
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = FolderModule.class)
public interface FoldersComponent {

    void inject(FoldersFragment foldersFragment);
}
