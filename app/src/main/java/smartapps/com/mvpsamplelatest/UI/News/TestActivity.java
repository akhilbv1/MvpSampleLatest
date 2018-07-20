package smartapps.com.mvpsamplelatest.UI.News;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import javax.inject.Inject;

import smartapps.com.mvpsamplelatest.Data.TestResponsePojo;
import smartapps.com.mvpsamplelatest.R;
import smartapps.com.mvpsamplelatest.UI.base.BaseActivity;

/*
 * Created by akhil on 20/7/18.
 */

public class TestActivity extends BaseActivity implements TestMvpView {

    @Inject
    TestPresenter<TestMvpView> presenter;
    private TextView tvEmail;
    private Button btnLogout;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialiseViews();
        getActivityComponent().inject(this);
        presenter.onAttach(this);
        presenter.getDetails();


    }

    public void initialiseViews() {
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading");

        tvEmail = findViewById(R.id.tvEmail);
        btnLogout = findViewById(R.id.logout);
    }

    @Override
    public void getDetailsSuccess(TestResponsePojo testResponsePojo) {
        tvEmail.setText(testResponsePojo.getTitle());
        btnLogout.setVisibility(View.GONE);
    }

    @Override
    public void getDetailsFailure(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onShowProgress() {
        progressDialog.show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDetach();
    }

    @Override
    public void onDismissProgress() {
        progressDialog.dismiss();
    }
}
