package com.android.tn.listener.injector.component;

import dagger.Component;
import com.android.tn.listener.injector.module.ActivityModule;
import com.android.tn.listener.injector.module.ArtistsModule;
import com.android.tn.listener.injector.scope.PerActivity;
import com.android.tn.listener.ui.fragment.ArtistFragment;

/**
 * Created by hefuyi on 2016/11/13.
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = {ActivityModule.class, ArtistsModule.class})
public interface ArtistComponent {

    void inject(ArtistFragment artistFragment);
}
