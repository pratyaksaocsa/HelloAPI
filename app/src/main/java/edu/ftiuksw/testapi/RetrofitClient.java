package edu.ftiuksw.testapi;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    //SINGLETON

    private static Retrofit retrofit;
    private static final String BASE_URL = "https://dummyjson.com/";

    public static Retrofit getRetrofitClient() {
        if(retrofit == null) {
            //HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            //interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            //OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();
            retrofit = new Retrofit.Builder().
                    baseUrl(BASE_URL).//client(client).
                    addConverterFactory(GsonConverterFactory.create()).
                    build();
        }
        return retrofit;
    }
}
