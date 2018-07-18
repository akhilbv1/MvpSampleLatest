package smartapps.com.mvpsamplelatest;

import android.app.Application;

import smartapps.com.mvpsamplelatest.Data.DataManager;
import smartapps.com.mvpsamplelatest.Data.SharedPrefHelper;

/**
 * Created by akhil on 18/7/18.
 */

public class MvpApp extends Application {

    DataManager dataManager;

    @Override
    public void onCreate() {
        super.onCreate();
        SharedPrefHelper sharedPrefHelper = new SharedPrefHelper(getApplicationContext());
        dataManager = new DataManager(sharedPrefHelper);
    }

    public DataManager getDataManager() {
        return dataManager;
    }
}

