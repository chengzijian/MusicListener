package com.android.tn.listener.injector.component;

import dagger.Component;
import com.android.tn.listener.injector.module.ArtistSongModule;
import com.android.tn.listener.injector.scope.PerActivity;
import com.android.tn.listener.ui.fragment.ArtistMusicFragment;

/**
 * Created by hefuyi on 2016/11/25.
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ArtistSongModule.class)
public interface ArtistSongsComponent {

    void inject(ArtistMusicFragment artistMusicFragment);
}
