package com.android.zj.listener.injector.component;

import dagger.Component;
import com.android.zj.listener.injector.module.ArtistInfoModule;
import com.android.zj.listener.injector.scope.PerActivity;
import com.android.zj.listener.ui.adapter.ArtistAdapter;
import com.android.zj.listener.ui.fragment.ArtistDetailFragment;

/**
 * Created by hefuyi on 2016/11/13.
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ArtistInfoModule.class)
public interface ArtistInfoComponent {

    void injectForAdapter(ArtistAdapter artistAdapter);

    void injectForFragment(ArtistDetailFragment fragment);
}
