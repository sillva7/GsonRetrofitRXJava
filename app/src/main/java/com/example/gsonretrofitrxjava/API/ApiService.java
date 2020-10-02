package com.example.gsonretrofitrxjava.API;

import com.example.gsonretrofitrxjava.classes.Response;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;

public interface ApiService {

    @GET("testTask.json")
    Observable<Response> getEmployees();


}
