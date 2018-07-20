package smartapps.com.mvpsamplelatest;

import android.util.Base64;


import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestClient {

    private static final String BASE_URL = "https://jsonplaceholder.typicode.com/";


    private RestApi restApi;

    public RestClient() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(buildOkHttpClient())
                .build();


        restApi = retrofit.create(RestApi.class);
    }

    public RestApi getRestApi() {
        return restApi;
    }


    // build OkHttp client
    private OkHttpClient buildOkHttpClient() {

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        // set your desired log level
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request original = chain.request();

                Request request = original.newBuilder()
                        .header("Content-Type", "application/json")
                        .header("Accept", "application/json")
                        .header("Accept-Language", "en-gb")
                        // .header("Authorization", getCustomAuth())
                        .method(original.method(), original.body())
                        .build();

                return chain.proceed(request);
            }
        });

        httpClient.addInterceptor(logging);
        httpClient.connectTimeout(1, TimeUnit.MINUTES);
        httpClient.readTimeout(1, TimeUnit.MINUTES);

        return httpClient.build();
    }

}
