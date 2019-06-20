package com.example.nytimesapp.repository;

public abstract class NYTimeListDataSource {

    public interface dataResult<T> {
        public void onSuccess(T result);

        public void onFailure(String messages);
    }

    public abstract void getNYList(dataResult dataResultListener);
}

