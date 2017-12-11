package com.android.tn.listener.injector.component;

import dagger.Component;
import com.android.tn.listener.injector.module.ArtistInfoModule;
import com.android.tn.listener.injector.scope.PerActivity;
import com.android.tn.listener.ui.adapter.ArtistAdapter;
import com.android.tn.listener.ui.fragment.ArtistDetailFragment;

/**
 * Created by hefuyi on 2016/11/13.
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ArtistInfoModule.class)
public interface ArtistInfoComponent {

    void injectForAdapter(ArtistAdapter artistAdapter);

    void injectForFragment(ArtistDetailFragment fragment);
}
