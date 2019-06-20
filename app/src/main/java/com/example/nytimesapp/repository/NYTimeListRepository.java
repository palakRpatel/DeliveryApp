package com.example.nytimesapp.repository;

public class NYTimeListRepository {


    private static NYTimeListRepository INSTANCE;
    private NYTimeListDataSource remoteDataSource;

    private NYTimeListRepository(NYTimeListDataSource nyTimeListDataSource) {
        this.remoteDataSource = nyTimeListDataSource;
    }

    public static NYTimeListRepository getInstance(NYTimeListDataSource nyTimeListDataSource) {

        if (INSTANCE == null) {
            INSTANCE = new NYTimeListRepository(nyTimeListDataSource);
        }
        return INSTANCE;
    }

    public void getNYList(final NYTimeListDataSource.dataResult dataSource) {
        remoteDataSource.getNYList(new NYTimeListDataSource.dataResult() {
            @Override
            public void onSuccess(Object result) {
                dataSource.onSuccess(result);
            }

            @Override
            public void onFailure(String messages) {
                dataSource.onFailure(messages);
            }
        });
    }
}
