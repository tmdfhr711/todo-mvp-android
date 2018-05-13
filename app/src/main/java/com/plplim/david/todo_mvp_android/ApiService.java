package com.plplim.david.todo_mvp_android;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface ApiService {
    //베이스 url
    String BASEURL = "http://apis.skplanetx.com/weather/current/";
    String APIKEY = "29df61f0-847d-3ef7-a837-1070542a2123";

    //get 메소드를 통한 http rest api통신
    @GET("hourly/")
    Call<JsonObject> getHourly(@Header("Appkey") String apiKey, @Query("version") int version,
                               @Query("lat") double lat, @Query("lon") double lon);
}
