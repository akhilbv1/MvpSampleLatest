package smartapps.com.mvpsamplelatest.UI.Splash;

import javax.inject.Inject;

import smartapps.com.mvpsamplelatest.Data.DataManager;
import smartapps.com.mvpsamplelatest.UI.base.BasePresenter;

/**
 * Created by akhil on 18/7/18.
 */

public class SplashPresenter<V extends SplashMvpView> extends BasePresenter<V> implements SplashMvpPresenter<V> {

    @Inject
    public SplashPresenter(DataManager mDataManager) {
        super(mDataManager);
    }

    @Override
    public void openNextActivity() {
        if (getDataManager().getLoggedInState()) {
            getMvpView().openMainActivity();
        } else {
            getMvpView().openLoginActivity();
        }
    }
}
