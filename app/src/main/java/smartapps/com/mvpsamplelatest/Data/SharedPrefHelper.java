package smartapps.com.mvpsamplelatest.Data;

import android.content.Context;
import android.content.SharedPreferences;

import javax.inject.Inject;

import smartapps.com.mvpsamplelatest.Di.Annotation.ApplicationContext;

/*
 * Created by akhil on 18/7/18.
 */

public class SharedPrefHelper {
    public static final String MY_PREFS = "MY_PREFS";

    public static final String EMAIL = "EMAIL";

    public static final String Password = "Password";

    public static final String IS_LOGGED_IN = "IsLogin";

    private SharedPreferences mSharedPreferences;

    @Inject
    public SharedPrefHelper(@ApplicationContext Context context) {
        this.mSharedPreferences = context.getSharedPreferences(MY_PREFS, Context.MODE_PRIVATE);
    }

    public void saveUserCredentials(String email,String password) {
        mSharedPreferences.edit().putString(EMAIL, email).apply();
        mSharedPreferences.edit().putString(Password,password).apply();
    }


    public String getEmail() {
        return mSharedPreferences.getString(EMAIL, "");
    }

    public String getPassword(){
        return mSharedPreferences.getString(Password,"");
    }

    public void clear() {
        mSharedPreferences.edit().clear().apply();
    }

    public void setLoggedinState(boolean isLogin) {
        mSharedPreferences.edit().putBoolean(IS_LOGGED_IN, isLogin).apply();
    }

    public boolean getLoginState() {
        return mSharedPreferences.getBoolean(IS_LOGGED_IN, false);
    }
}
