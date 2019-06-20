package com.example.nytimesapp;

import com.example.nytimesapp.data.NYListResponse;

public interface NYTimesListContract {

    interface Presenter {
        void start();

        void callNYListRepostitory();
    }

    interface View {
        void setPresenter(NYTimesListContract.Presenter presenter);

        void setAdapter(NYListResponse nyListResponse);

        void init();

        void showProgressDialog();

        void hideProgressDialog();
    }
}
