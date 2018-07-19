package smartapps.com.mvpsamplelatest.UI.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import smartapps.com.mvpsamplelatest.Di.Component.ActivityComponent;
import smartapps.com.mvpsamplelatest.Di.Component.DaggerActivityComponent;
import smartapps.com.mvpsamplelatest.Di.Module.ActivityModule;
import smartapps.com.mvpsamplelatest.MvpApp;

/*
 * Created by akhil on 18/7/18.
 */

public class BaseActivity extends AppCompatActivity implements MvpView {

    private ActivityComponent activityComponent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initialiseViews();
    }

    public ActivityComponent getActivityComponent() {
        if (activityComponent == null) {
            activityComponent = DaggerActivityComponent.builder()
                    .activityModule(new ActivityModule(this))
                    .applicationComponent(MvpApp.get(this).getApplicationComponent())
                    .build();
        }
        return activityComponent;
    }

    @Override
    public void initialiseViews() {

    }

    //initialise views
    // private void initiaseViews(){}


}
