package com.android.zj.listener.injector.component;

import dagger.Component;
import com.android.zj.listener.injector.module.AlbumSongsModel;
import com.android.zj.listener.injector.scope.PerActivity;
import com.android.zj.listener.ui.fragment.AlbumDetailFragment;

/**
 * Created by hefuyi on 2016/12/3.
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = AlbumSongsModel.class)
public interface AlbumSongsComponent {

    void inject(AlbumDetailFragment albumDetailFragment);

}
