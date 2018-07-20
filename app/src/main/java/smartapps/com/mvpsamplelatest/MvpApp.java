package smartapps.com.mvpsamplelatest;

import android.app.Application;
import android.content.Context;

import smartapps.com.mvpsamplelatest.Di.Component.ApplicationComponent;
import smartapps.com.mvpsamplelatest.Di.Component.DaggerApplicationComponent;
import smartapps.com.mvpsamplelatest.Di.Module.ApplicationModule;

/*
 * Created by akhil on 18/7/18.
 */

public class MvpApp extends Application {

    // DataManager dataManager;

    static RestClient restClient;
    ApplicationComponent applicationComponent;

    public static RestClient getRestClient() {
        return restClient;
    }

    public static MvpApp get(Context context) {
        return (MvpApp) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        // dataManager = new DataManager(sharedPrefHelper);

        restClient = new RestClient();

        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
        applicationComponent.inject(this);

    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }


    /*public DataManager getDataManager() {
        return dataManager;
    }*/
}

