package com.example.nytimesapp.remote;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.example.nytimesapp.data.NYListResponse;
import com.example.nytimesapp.repository.NYTimeListDataSource;
import com.example.nytimesapp.repository.NYTimeListRepository;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;

public class NYTimeListRemoteDataSourceTest {


    @Mock
    NYTimeListRemoteDataSource remoteDataSource;

    @Mock
    RequestQueue requestQueue;

    @Mock
    private NYListResponse nyListResponse;

    @Mock
    private NYTimeListDataSource dataSource;

    @Mock
    StringRequest stringRequest;

    @Mock
    private NYTimeListDataSource.dataResult dataResult;
    @Captor
    ArgumentCaptor<NYTimeListDataSource.dataResult> nyListResponseArgumentCaptor;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        remoteDataSource = NYTimeListRemoteDataSource.getInstance(requestQueue);
    }



}