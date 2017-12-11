package com.android.tn.listener.injector.component;

import dagger.Component;
import com.android.tn.listener.injector.module.PlaylistModule;
import com.android.tn.listener.injector.scope.PerActivity;
import com.android.tn.listener.ui.fragment.PlaylistFragment;

/**
 * Created by hefuyi on 2016/12/5.
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = PlaylistModule.class)
public interface PlaylistComponent {

    void inject(PlaylistFragment playlistFragment);
}
