package smartapps.com.mvpsamplelatest.UI.UserDetails;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import javax.inject.Inject;

import smartapps.com.mvpsamplelatest.R;
import smartapps.com.mvpsamplelatest.UI.base.BaseActivity;

/*
 * Created by akhil on 18/7/18.
 */

public class UserDetailsActivity extends BaseActivity implements UserDetailsMvpView, View.OnClickListener {

    @Inject
    UserDetailsPresenter<UserDetailsMvpView> userDetailsPresenter;
    private TextView tvEmail;
    private Button btnLogout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialiseViewss();
        getActivityComponent().inject(this);
        userDetailsPresenter.onAttach(this);
        userDetailsPresenter.getUserDetails();
        userDetailsPresenter.setUserLoggedInStatus(true);
        btnLogout.setOnClickListener(this);
    }

    public void initialiseViewss() {
        super.initialiseViews();
        tvEmail = findViewById(R.id.tvEmail);
        btnLogout = findViewById(R.id.logout);
    }

    @Override
    public void getUserDetails(String email) {
        tvEmail.setText(email);
    }

    @Override
    public void onClick(View v) {
        userDetailsPresenter.setUserLoggedInStatus(false);
    }
}
