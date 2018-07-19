package smartapps.com.mvpsamplelatest.Di.Component;

import android.app.Application;
import android.content.Context;

import dagger.Component;
import smartapps.com.mvpsamplelatest.Data.DataManager;
import smartapps.com.mvpsamplelatest.Di.Annotation.ApplicationContext;
import smartapps.com.mvpsamplelatest.Di.Module.ApplicationModule;

/**
 * Created by akhil on 19/7/18.
 */

@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(Application application);

    DataManager getDatamanager();

    @ApplicationContext
    Context getContext();
}
