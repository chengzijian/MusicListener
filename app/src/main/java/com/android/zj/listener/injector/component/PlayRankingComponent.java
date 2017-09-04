package com.android.zj.listener.injector.component;

import dagger.Component;
import com.android.zj.listener.injector.module.PlayRankingModule;
import com.android.zj.listener.injector.scope.PerActivity;
import com.android.zj.listener.ui.fragment.PlayRankingFragment;

/**
 * Created by hefuyi on 2016/12/9.
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = PlayRankingModule.class)
public interface PlayRankingComponent {

    void inject(PlayRankingFragment playRankingFragment);
}
