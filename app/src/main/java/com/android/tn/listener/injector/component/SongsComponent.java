package com.android.tn.listener.injector.component;

import dagger.Component;
import com.android.tn.listener.injector.module.ActivityModule;
import com.android.tn.listener.injector.module.SongsModule;
import com.android.tn.listener.injector.scope.PerActivity;
import com.android.tn.listener.ui.fragment.SongsFragment;

/**
 * Created by hefuyi on 2016/11/12.
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = {ActivityModule.class, SongsModule.class})
public interface SongsComponent {

    void inject(SongsFragment songsFragment);
}
