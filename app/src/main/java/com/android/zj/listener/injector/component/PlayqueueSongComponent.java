package com.android.zj.listener.injector.component;

import dagger.Component;
import com.android.zj.listener.injector.module.PlayqueueSongModule;
import com.android.zj.listener.injector.scope.PerActivity;
import com.android.zj.listener.ui.dialogs.PlayqueueDialog;

/**
 * Created by hefuyi on 2016/12/27.
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = PlayqueueSongModule.class)
public interface PlayqueueSongComponent {

    void inject(PlayqueueDialog playqueueDialog);
}
