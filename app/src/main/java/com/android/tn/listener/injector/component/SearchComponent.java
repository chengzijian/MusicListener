package com.android.tn.listener.injector.component;

import dagger.Component;
import com.android.tn.listener.injector.module.SearchModule;
import com.android.tn.listener.injector.scope.PerActivity;
import com.android.tn.listener.ui.fragment.SearchFragment;

/**
 * Created by hefuyi on 2017/1/3.
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = SearchModule.class)
public interface SearchComponent {

    void inject(SearchFragment searchFragment);
}
