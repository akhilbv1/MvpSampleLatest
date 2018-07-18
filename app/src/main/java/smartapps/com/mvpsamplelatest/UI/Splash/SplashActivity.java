package smartapps.com.mvpsamplelatest.UI.Splash;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import smartapps.com.mvpsamplelatest.Data.DataManager;
import smartapps.com.mvpsamplelatest.MvpApp;

import smartapps.com.mvpsamplelatest.UI.Login.LoginActivity;
import smartapps.com.mvpsamplelatest.UI.UserDetails.UserDetailsActivity;
import smartapps.com.mvpsamplelatest.UI.base.BaseActivity;

/**
 * Created by akhil on 18/7/18.
 */

public class SplashActivity extends BaseActivity implements SplashMvpView {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DataManager dataManager = ((MvpApp)getApplication()).getDataManager();
        SplashPresenter mPresenter = new SplashPresenter(dataManager);
        mPresenter.onAttach(this);
        mPresenter.openNextActivity();

    }

    @Override
    public void openMainActivity() {
        Intent intent = new Intent(SplashActivity.this, UserDetailsActivity.class);
        startActivity(intent);
    }

    @Override
    public void openLoginActivity() {
        Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
        startActivity(intent);
    }
}
