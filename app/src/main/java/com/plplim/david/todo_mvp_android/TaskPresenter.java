package com.plplim.david.todo_mvp_android;

import com.plplim.david.todo_mvp_android.TaskContract;

public class TaskPresenter implements TaskContract.Presenter, WeatherCallback {

    WeatherRepository weatherRepository;
    TaskContract.View view;

    public TaskPresenter(TaskContract.View view) {
        this.view = view;
        view.setPresenter(this);
    }

    @Override
    public void start() {

    }

    @Override
    public void getWeather(double lat, double lon) {
        weatherRepository = new WeatherRepository(this);
    }

    @Override
    public void callBack(String weather) {
        view.showWeather(weather);
    }
}
