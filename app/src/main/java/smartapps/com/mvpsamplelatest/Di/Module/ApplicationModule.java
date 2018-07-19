package smartapps.com.mvpsamplelatest.Di.Module;

import android.app.Application;
import android.content.Context;

import javax.inject.Inject;

import dagger.Module;
import dagger.Provides;
import smartapps.com.mvpsamplelatest.Di.Annotation.ApplicationContext;

/**
 * Created by akhil on 19/7/18.
 */

@Module
public class ApplicationModule {
    private Application mApplication;

    public ApplicationModule(Application application)
    {
        this.mApplication = application;
    }

    @Provides
    public Application proviesApplication(){
        return mApplication;
    }

    @Provides
    @ApplicationContext
    public Context provideContext(){
        return mApplication.getApplicationContext();
    }
}
