package com.example.gsonretrofitrxjava.API;

import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiFactory {

    private static ApiFactory apiFactory;
    private static Retrofit retrofit;
    private String BASE_URL = "http://gitlab.65apps.com/65gb/static/raw/master/";


    private ApiFactory() {
        retrofit = new Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create()).baseUrl(BASE_URL).build();
    }


    public static ApiFactory getInstance() {
        if (apiFactory == null) {
            apiFactory = new ApiFactory();
        }
        return apiFactory;//плохо. т.к. возвращает нуль
    }

    public ApiService getApiService(){
        return retrofit.create(ApiService.class);
    }

}
