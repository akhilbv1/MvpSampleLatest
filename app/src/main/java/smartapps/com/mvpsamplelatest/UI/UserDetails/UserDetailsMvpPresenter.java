package smartapps.com.mvpsamplelatest.UI.UserDetails;

import smartapps.com.mvpsamplelatest.UI.base.MvpPresenter;

/**
 * Created by akhil on 18/7/18.
 */

public interface UserDetailsMvpPresenter<V extends UserDetailsMvpView> extends MvpPresenter<V>{

    void getUserDetails();

    void setUserLoggedInStatus(boolean isLogin);
}
