package com.android.zj.listener.injector.component;

import dagger.Component;
import com.android.zj.listener.injector.module.PlaylistSongModule;
import com.android.zj.listener.injector.scope.PerActivity;
import com.android.zj.listener.ui.fragment.PlaylistDetailFragment;

/**
 * Created by hefuyi on 2016/12/6.
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = PlaylistSongModule.class)
public interface PlaylistSongComponent {

    void inject(PlaylistDetailFragment playlistDetailFragment);
}
