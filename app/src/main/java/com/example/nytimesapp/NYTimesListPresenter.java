package com.example.nytimesapp;

import android.util.Log;

import com.example.nytimesapp.repository.NYTimeListDataSource;
import com.example.nytimesapp.repository.NYTimeListRepository;
import com.example.nytimesapp.data.NYListResponse;

public class NYTimesListPresenter implements NYTimesListContract.Presenter {

    NYTimesListContract.View view;
    NYTimeListRepository repository;

    public NYTimesListPresenter(NYTimesListContract.View view, NYTimeListRepository nyTimeListRepository) {
        this.view = view;
        this.repository = nyTimeListRepository;
        view.setPresenter(this);

    }

    @Override
    public void start() {
        view.init();
    }


    @Override
    public void callNYListRepostitory() {
        view.showProgressDialog();
        repository.getNYList(new NYTimeListDataSource.dataResult() {
            @Override
            public void onSuccess(Object result) {
                if (result != null) {
                    NYListResponse response = (NYListResponse) result;
                    view.setAdapter(response);
                    view.hideProgressDialog();
                }
            }

            @Override
            public void onFailure(String messages) {
                view.hideProgressDialog();
            }
        });
    }
}
