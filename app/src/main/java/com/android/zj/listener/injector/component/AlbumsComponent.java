package com.android.zj.listener.injector.component;

import dagger.Component;
import com.android.zj.listener.injector.module.ActivityModule;
import com.android.zj.listener.injector.module.AlbumsModule;
import com.android.zj.listener.injector.scope.PerActivity;
import com.android.zj.listener.ui.fragment.AlbumFragment;

/**
 * Created by hefuyi on 2016/11/12.
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = {ActivityModule.class, AlbumsModule.class})
public interface AlbumsComponent {

    void inject(AlbumFragment albumFragment);
}
