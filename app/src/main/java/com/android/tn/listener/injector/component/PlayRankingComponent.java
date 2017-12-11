package com.android.tn.listener.injector.component;

import dagger.Component;
import com.android.tn.listener.injector.module.PlayRankingModule;
import com.android.tn.listener.injector.scope.PerActivity;
import com.android.tn.listener.ui.fragment.PlayRankingFragment;

/**
 * Created by hefuyi on 2016/12/9.
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = PlayRankingModule.class)
public interface PlayRankingComponent {

    void inject(PlayRankingFragment playRankingFragment);
}
