package smartapps.com.mvpsamplelatest.UI.Login;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import javax.inject.Inject;

import smartapps.com.mvpsamplelatest.MvpApp;
import smartapps.com.mvpsamplelatest.R;
import smartapps.com.mvpsamplelatest.UI.Register.RegisterActivity;
import smartapps.com.mvpsamplelatest.UI.UserDetails.UserDetailsActivity;
import smartapps.com.mvpsamplelatest.UI.base.BaseActivity;

/**
 * Created by akhil on 18/7/18.
 */

public class LoginActivity extends BaseActivity implements LoginMvpView, View.OnClickListener {

    private EditText etEmail, etPassword;

    private Button login, register;

    @Inject LoginPresenter<LoginMvpView> loginPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);
        initialiseViewss();
        login.setOnClickListener(this);
        register.setOnClickListener(this);
        getActivityComponent().inject(this);
        //loginPresenter = new LoginPresenter(((MvpApp) getApplication()).getDataManager());
        loginPresenter.onAttach(this);

    }

    public void initialiseViewss() {
        super.initialiseViews();
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        login = findViewById(R.id.login);
        register = findViewById(R.id.register);
    }

    @Override
    public void isValidUser(boolean isValidUser) {
        if (isValidUser)
            openMainActivity();
        else
            Toast.makeText(this, "invalid credentials", Toast.LENGTH_SHORT).show();

    }

    private void openMainActivity() {
        Intent intent = new Intent(this, UserDetailsActivity.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.login)
            validateAndLogin();
        else if (v.getId() == R.id.register) {
            Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
            startActivity(intent);
        }
    }

    //validate user
    private void validateAndLogin() {
        if (TextUtils.isEmpty(etEmail.getText().toString().trim())) {
            Toast.makeText(this, "enter email", Toast.LENGTH_SHORT).show();
        } else if (!Patterns.EMAIL_ADDRESS.matcher(etEmail.getText().toString()).matches()) {
            Toast.makeText(this, "enter valid email", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(etPassword.getText().toString().trim())) {
            Toast.makeText(this, "enter password", Toast.LENGTH_SHORT).show();
        } else {
            loginPresenter.validateUser(etEmail.getText().toString().trim(), etPassword.getText().toString().trim());
        }
    }
}
