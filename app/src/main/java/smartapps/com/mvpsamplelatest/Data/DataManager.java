package smartapps.com.mvpsamplelatest.Data;

/*
 * Created by akhil on 18/7/18.
 */

import javax.inject.Inject;

import retrofit2.Call;
import smartapps.com.mvpsamplelatest.MvpApp;

public class DataManager {

    private SharedPrefHelper mSharedPref;

    @Inject
    public DataManager(SharedPrefHelper mSharedPref) {
        this.mSharedPref = mSharedPref;
    }

    public void clearAllUsers() {
        mSharedPref.clear();
    }

    public void addUser(String email, String password) {
        mSharedPref.saveUserCredentials(email, password);
    }

    public Call<TestResponsePojo> getDetailsCall(){
        return MvpApp.getRestClient().getRestApi().getDetails();
    }

    public String getEmail() {
        return mSharedPref.getEmail();
    }

    public String getPassword() {
        return mSharedPref.getPassword();
    }

    public void setLoggedIn(boolean isLoggedIn) {
        mSharedPref.setLoggedinState(isLoggedIn);
    }

    public boolean getLoggedInState() {
        return mSharedPref.getLoginState();
    }
}
