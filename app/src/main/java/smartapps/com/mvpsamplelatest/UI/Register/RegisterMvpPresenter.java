package smartapps.com.mvpsamplelatest.UI.Register;

import smartapps.com.mvpsamplelatest.UI.base.MvpPresenter;

/*
 * Created by akhil on 18/7/18.
 */

public interface RegisterMvpPresenter<V extends RegisterMvpView> extends MvpPresenter<V> {

    void registerUser(String email,String password);
}
