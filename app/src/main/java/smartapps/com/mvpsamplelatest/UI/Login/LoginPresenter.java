package smartapps.com.mvpsamplelatest.UI.Login;

import android.support.annotation.NonNull;

import javax.inject.Inject;

import smartapps.com.mvpsamplelatest.Data.DataManager;
import smartapps.com.mvpsamplelatest.UI.base.BasePresenter;

/*
 * Created by akhil on 18/7/18.
 */

public class LoginPresenter<V extends LoginMvpView> extends BasePresenter<V> implements LoginMvpPresenter<V> {

    @Inject
    public LoginPresenter(DataManager mDataManager) {
        super(mDataManager);
    }

    @Override
    public void validateUser(@NonNull String email,@NonNull String password) {
        if(getDataManager().getEmail().equalsIgnoreCase(email) && getDataManager().getPassword().equalsIgnoreCase(password))
        {
            getMvpView().isValidUser(true);
        }
        else
        {
            getMvpView().isValidUser(false);
        }
    }
}
