package com.android.tn.listener.injector.component;

import dagger.Component;
import com.android.tn.listener.injector.module.PlaylistSongModule;
import com.android.tn.listener.injector.scope.PerActivity;
import com.android.tn.listener.ui.fragment.PlaylistDetailFragment;

/**
 * Created by hefuyi on 2016/12/6.
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = PlaylistSongModule.class)
public interface PlaylistSongComponent {

    void inject(PlaylistDetailFragment playlistDetailFragment);
}
