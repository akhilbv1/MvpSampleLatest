package smartapps.com.mvpsamplelatest.UI.Splash;

import smartapps.com.mvpsamplelatest.UI.base.MvpPresenter;

/**
 * Created by akhil on 18/7/18.
 */

public interface SplashMvpPresenter<V extends SplashMvpView> extends MvpPresenter<V> {

    void openNextActivity();
}
