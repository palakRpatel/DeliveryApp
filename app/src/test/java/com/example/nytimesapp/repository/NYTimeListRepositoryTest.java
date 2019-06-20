package com.example.nytimesapp.repository;

import com.example.nytimesapp.data.NYListResponse;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;

public class NYTimeListRepositoryTest {


    @Mock
    NYTimeListRepository repository;

    @Mock
    private NYListResponse nyListResponse;

    @Mock
    private NYTimeListDataSource dataSource;

    @Mock
    private NYTimeListDataSource.dataResult dataResult;
    @Captor
    ArgumentCaptor<NYTimeListDataSource.dataResult> nyListResponseArgumentCaptor;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        repository = NYTimeListRepository.getInstance(dataSource);
    }

    @Test
    public void callNYListRepostitory() {
        repository.getNYList(dataResult);
        verify(dataSource).getNYList(nyListResponseArgumentCaptor.capture());
        NYTimeListDataSource.dataResult dataResult = nyListResponseArgumentCaptor.getValue();
        dataResult.onSuccess(nyListResponse);
    }


}