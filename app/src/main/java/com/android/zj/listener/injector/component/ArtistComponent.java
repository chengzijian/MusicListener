package com.android.zj.listener.injector.component;

import dagger.Component;
import com.android.zj.listener.injector.module.ActivityModule;
import com.android.zj.listener.injector.module.ArtistsModule;
import com.android.zj.listener.injector.scope.PerActivity;
import com.android.zj.listener.ui.fragment.ArtistFragment;

/**
 * Created by hefuyi on 2016/11/13.
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = {ActivityModule.class, ArtistsModule.class})
public interface ArtistComponent {

    void inject(ArtistFragment artistFragment);
}
