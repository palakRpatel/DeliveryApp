package com.example.nytimesapp;

import com.example.nytimesapp.data.NYListResponse;
import com.example.nytimesapp.repository.NYTimeListDataSource;
import com.example.nytimesapp.repository.NYTimeListRepository;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;

public class NYTimesListPresenterTest {

    @Mock
    NYTimesListContract.Presenter presenter;

    @Mock
    NYTimesListContract.View view;

    @Mock
    NYTimeListRepository repository;

    @Mock
    private NYListResponse nyListResponse;

    @Captor
    ArgumentCaptor<NYTimeListDataSource.dataResult> nyListResponseArgumentCaptor;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        presenter = new NYTimesListPresenter(view, repository);
    }

    @Test
    public void start() {
        presenter.start();
    }

    @Test
    public void callNYListRepostitory() {
        presenter.callNYListRepostitory();
        verify(repository).getNYList(nyListResponseArgumentCaptor.capture());
        NYTimeListDataSource.dataResult dataResult = nyListResponseArgumentCaptor.getValue();
        dataResult.onSuccess(nyListResponse);
        verify(view).showProgressDialog();
        verify(view).setAdapter(nyListResponse);
        verify(view).hideProgressDialog();
    }

    @Test
    public void callNYListRepostitoryFailure() {
        presenter.callNYListRepostitory();
        verify(repository).getNYList(nyListResponseArgumentCaptor.capture());
        NYTimeListDataSource.dataResult dataResult = nyListResponseArgumentCaptor.getValue();
        dataResult.onFailure("fail");
        verify(view).showProgressDialog();
        verify(view).hideProgressDialog();

    }

}