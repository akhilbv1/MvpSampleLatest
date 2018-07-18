package smartapps.com.mvpsamplelatest.UI.Login;

import smartapps.com.mvpsamplelatest.UI.base.MvpPresenter;

/**
 * Created by akhil on 18/7/18.
 */

public interface LoginMvpPresenter<V extends LoginMvpView> extends MvpPresenter<V> {
    void validateUser(String email,String password);
}
