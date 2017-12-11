package com.android.tn.listener.injector.component;

import android.app.Application;

import dagger.Component;
import com.android.tn.listener.ListenerApp;
import com.android.tn.listener.injector.module.ApplicationModule;
import com.android.tn.listener.injector.module.NetworkModule;
import com.android.tn.listener.injector.scope.PerApplication;
import com.android.tn.listener.respository.interfaces.Repository;

/**
 * Created by hefuyi on 2016/11/3.
 */
@PerApplication
@Component(modules = {ApplicationModule.class, NetworkModule.class})
public interface ApplicationComponent {

    Application application();

    ListenerApp listenerApplication();

    Repository repository();
}
