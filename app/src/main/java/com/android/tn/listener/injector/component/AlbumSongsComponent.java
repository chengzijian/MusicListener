package com.android.tn.listener.injector.component;

import dagger.Component;
import com.android.tn.listener.injector.module.AlbumSongsModel;
import com.android.tn.listener.injector.scope.PerActivity;
import com.android.tn.listener.ui.fragment.AlbumDetailFragment;

/**
 * Created by hefuyi on 2016/12/3.
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = AlbumSongsModel.class)
public interface AlbumSongsComponent {

    void inject(AlbumDetailFragment albumDetailFragment);

}
