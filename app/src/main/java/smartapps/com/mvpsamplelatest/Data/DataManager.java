package smartapps.com.mvpsamplelatest.Data;

/*
 * Created by akhil on 18/7/18.
 */

public class DataManager {

    private SharedPrefHelper mSharedPref;

    public DataManager(SharedPrefHelper mSharedPref) {
        this.mSharedPref = mSharedPref;
    }

    public void clearAllUsers() {
        mSharedPref.clear();
    }

    public void addUser(String email, String password) {
        mSharedPref.saveUserCredentials(email, password);
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
