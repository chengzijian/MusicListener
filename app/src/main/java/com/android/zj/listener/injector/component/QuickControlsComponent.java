package com.android.zj.listener.injector.component;

import dagger.Component;
import com.android.zj.listener.injector.module.ActivityModule;
import com.android.zj.listener.injector.module.QuickControlsModule;
import com.android.zj.listener.injector.scope.PerActivity;
import com.android.zj.listener.ui.fragment.QuickControlsFragment;

/**
 * Created by hefuyi on 2016/11/8.
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = {ActivityModule.class, QuickControlsModule.class})
public interface QuickControlsComponent {

    void inject(QuickControlsFragment quickControlsFragment);

}
