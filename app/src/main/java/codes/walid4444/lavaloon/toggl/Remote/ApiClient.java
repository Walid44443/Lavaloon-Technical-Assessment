package codes.walid4444.lavaloon.toggl.Remote;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import codes.walid4444.lavaloon.toggl.CONST;
import codes.walid4444.lavaloon.toggl.Remote.Models.LoginDataModel;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class ApiClient {


    public static final String BASE_URL = CONST.API_FILE_DOMAIN;
    public static final String PATH_URL = CONST.API_PATH_URL;

    private static Retrofit retrofit = null;


    public static Retrofit getClient(LoginDataModel loginDataModel) {
        if (retrofit == null) {
            Gson gson = new GsonBuilder()
                    .setLenient()
                    .create();

            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.level(HttpLoggingInterceptor.Level.BODY);

            OkHttpClient okHttpClient = new OkHttpClient.Builder()
                    .readTimeout(60, TimeUnit.SECONDS)
                    .connectTimeout(60, TimeUnit.SECONDS)
                    .writeTimeout(60, TimeUnit.SECONDS)
                    .addInterceptor(new BasicAuthInterceptor(loginDataModel.getUser(), loginDataModel.getPassword()))
                    .build();





            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL+""+PATH_URL)
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .client(okHttpClient)
                    .build();
            }
        return retrofit;
    }
}