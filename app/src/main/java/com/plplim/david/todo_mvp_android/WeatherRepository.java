package com.plplim.david.todo_mvp_android;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WeatherRepository {
    WeatherCallback weatherCallback;

    public WeatherRepository(WeatherCallback weatherCallback) {
        this.weatherCallback = weatherCallback;
    }

    public void getWeather(double latitude, double longitude) {

        Retrofit retrofit = new Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
                .baseUrl(ApiService.BASEURL)
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        Call<JsonObject> call = apiService.getHourly(ApiService.APIKEY, 1, latitude, longitude);
        call.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if (response.isSuccessful()) {
                    //날씨 데이터를 받아옴
                    JsonObject object = response.body();
                    if (object != null) {
                        weatherCallback.callBack(object.toString());
                    }
                }
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {

            }
        });



    }
}
