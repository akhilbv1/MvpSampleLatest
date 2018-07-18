package smartapps.com.mvpsamplelatest.UI.Register;

import android.support.annotation.NonNull;
import android.text.TextUtils;

import smartapps.com.mvpsamplelatest.Data.DataManager;
import smartapps.com.mvpsamplelatest.UI.base.BasePresenter;

/**
 * Created by akhil on 18/7/18.
 */

public class RegisterPresenter<V extends RegisterMvpView> extends BasePresenter<V> implements RegisterMvpPresenter<V> {
    public RegisterPresenter(DataManager mDataManager) {
        super(mDataManager);
    }

    @Override
    public void registerUser(@NonNull String email,@NonNull String password) {
        getDataManager().addUser(email,password);
        getMvpView().isUserRegistered(true);
    }
}
