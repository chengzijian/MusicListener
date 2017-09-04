package com.android.zj.listener.injector.component;

import dagger.Component;
import com.android.zj.listener.injector.module.PlaylistModule;
import com.android.zj.listener.injector.scope.PerActivity;
import com.android.zj.listener.ui.fragment.PlaylistFragment;

/**
 * Created by hefuyi on 2016/12/5.
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = PlaylistModule.class)
public interface PlaylistComponent {

    void inject(PlaylistFragment playlistFragment);
}
