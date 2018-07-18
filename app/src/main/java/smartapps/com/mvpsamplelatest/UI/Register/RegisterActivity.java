package smartapps.com.mvpsamplelatest.UI.Register;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import smartapps.com.mvpsamplelatest.MvpApp;
import smartapps.com.mvpsamplelatest.R;
import smartapps.com.mvpsamplelatest.UI.base.BaseActivity;

/**
 * Created by akhil on 18/7/18.
 */

public class RegisterActivity extends BaseActivity implements RegisterMvpView, View.OnClickListener {

    private EditText etEmail, etPassword;

    private Button btnRegister;

    private RegisterPresenter registerPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initialiseViewss();
        btnRegister.setOnClickListener(this);
        registerPresenter = new RegisterPresenter(((MvpApp)getApplication()).getDataManager());
        registerPresenter.onAttach(this);
    }

    public void initialiseViewss() {
        super.initialiseViews();
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        btnRegister = findViewById(R.id.reg);
    }

    @Override
    public void isUserRegistered(boolean isRegistered) {
        if (isRegistered) {
            Toast.makeText(this, "User Registered", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "User Registration failed", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onClick(View v) {
        validateAndRegister();
    }

    private void validateAndRegister() {
        if (TextUtils.isEmpty(etEmail.getText().toString().trim())) {
            Toast.makeText(this, "enter email", Toast.LENGTH_SHORT).show();
        } else if (!Patterns.EMAIL_ADDRESS.matcher(etEmail.getText().toString()).matches()) {
            Toast.makeText(this, "enter valid email", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(etPassword.getText().toString().trim())) {
            Toast.makeText(this, "enter password", Toast.LENGTH_SHORT).show();
        } else {
            registerPresenter.registerUser(etEmail.getText().toString().trim(), etPassword.getText().toString().trim());
        }
    }
}
