package smartapps.com.mvpsamplelatest;

import retrofit2.Call;
import retrofit2.http.GET;
import smartapps.com.mvpsamplelatest.Data.TestResponsePojo;

/**
 * Created by akhil on 20/7/18.
 */

public interface RestApi {

    @GET("posts/1")
    Call<TestResponsePojo> getDetails();
}
