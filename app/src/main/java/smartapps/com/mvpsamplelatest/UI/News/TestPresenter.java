package smartapps.com.mvpsamplelatest.UI.News;

import android.support.annotation.NonNull;
import android.util.Log;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import smartapps.com.mvpsamplelatest.Data.DataManager;
import smartapps.com.mvpsamplelatest.Data.TestResponsePojo;
import smartapps.com.mvpsamplelatest.UI.base.BasePresenter;

/**
 * Created by akhil on 20/7/18.
 */

public class TestPresenter<V extends TestMvpView> extends BasePresenter<V> {

    @Inject
    public TestPresenter(DataManager mDataManager) {
        super(mDataManager);
    }


    void getDetails() {
        getMvpView().onShowProgress();

        getDataManager().getDetailsCall().enqueue(new Callback<TestResponsePojo>() {
            @Override
            public void onResponse(@NonNull Call<TestResponsePojo> call, @NonNull Response<TestResponsePojo> response) {
                getMvpView().onDismissProgress();
                Log.i("values", "" + response.body().getTitle());
                getMvpView().getDetailsSuccess(response.body());
            }

            @Override
            public void onFailure(@NonNull Call<TestResponsePojo> call, @NonNull Throwable t) {
                getMvpView().onDismissProgress();
                getMvpView().getDetailsFailure(t.getMessage());
            }
        });
    }
}
