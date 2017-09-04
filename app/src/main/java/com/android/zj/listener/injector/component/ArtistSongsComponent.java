package com.android.zj.listener.injector.component;

import dagger.Component;
import com.android.zj.listener.injector.module.ArtistSongModule;
import com.android.zj.listener.injector.scope.PerActivity;
import com.android.zj.listener.ui.fragment.ArtistMusicFragment;

/**
 * Created by hefuyi on 2016/11/25.
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ArtistSongModule.class)
public interface ArtistSongsComponent {

    void inject(ArtistMusicFragment artistMusicFragment);
}
