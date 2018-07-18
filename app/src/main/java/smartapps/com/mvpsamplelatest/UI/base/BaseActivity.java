package smartapps.com.mvpsamplelatest.UI.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/*
 * Created by akhil on 18/7/18.
 */

public class BaseActivity extends AppCompatActivity implements MvpView {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initialiseViews();
    }

    @Override
    public void initialiseViews() {

    }

    //initialise views
   // private void initiaseViews(){}


}
