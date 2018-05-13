package com.plplim.david.todo_mvp_android;

public class TaskContract {
    /*
     * 위치정보를 받아와서 모델에게 위치정보를 넘겨주고
     * 날씨데이터를 받으면 텍스트로 넘겨주는 일을 함
     *
     * 프레젠터가 가져야할 기능에 대해서만 정의를 함
     */
    interface Presenter extends BasePresenter {
        void getWeather(double lat, double lon);
    }

    interface View extends BaseView<Presenter> {
        void showWeather(String weather);
    }

}
