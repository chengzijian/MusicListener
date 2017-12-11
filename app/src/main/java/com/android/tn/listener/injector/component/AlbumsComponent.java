package com.android.tn.listener.injector.component;

import dagger.Component;
import com.android.tn.listener.injector.module.ActivityModule;
import com.android.tn.listener.injector.module.AlbumsModule;
import com.android.tn.listener.injector.scope.PerActivity;
import com.android.tn.listener.ui.fragment.AlbumFragment;

/**
 * Created by hefuyi on 2016/11/12.
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = {ActivityModule.class, AlbumsModule.class})
public interface AlbumsComponent {

    void inject(AlbumFragment albumFragment);
}
