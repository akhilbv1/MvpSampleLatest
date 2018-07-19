package smartapps.com.mvpsamplelatest.UI.UserDetails;

import android.text.TextUtils;

import javax.inject.Inject;

import smartapps.com.mvpsamplelatest.Data.DataManager;
import smartapps.com.mvpsamplelatest.UI.base.BasePresenter;

/**
 * Created by akhil on 18/7/18.
 */

public class UserDetailsPresenter<V extends UserDetailsMvpView> extends BasePresenter<V> implements UserDetailsMvpPresenter<V> {

    @Inject
    public UserDetailsPresenter(DataManager mDataManager) {
        super(mDataManager);
    }

    @Override
    public void getUserDetails() {
        if(!TextUtils.isEmpty(getDataManager().getEmail()))
        {
            getMvpView().getUserDetails(getDataManager().getEmail());
        }
    }

    @Override
    public void setUserLoggedInStatus(boolean isLogin) {
        getDataManager().setLoggedIn(isLogin);
    }
}
