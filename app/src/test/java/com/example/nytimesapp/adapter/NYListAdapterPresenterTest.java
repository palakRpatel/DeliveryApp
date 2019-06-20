package com.example.nytimesapp.adapter;

import com.example.nytimesapp.data.NYListResponse;
import com.example.nytimesapp.data.Result;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.internal.stubbing.answers.Returns;
import org.mockito.stubbing.Answer;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


public class NYListAdapterPresenterTest {

    @Mock
    private NYListAdapterPresenter nyListAdapterPresenter;
    @Mock
    private List<Result> responseList;

    @Mock
    private NYListResponse nyListResponse;

    @Mock
    private Result result;

    @Mock
    private NYListViewHolder viewHolder;


    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        result.setTitle("test");
        responseList.add(result);
    }

    @Test
    public void bindRow() {

        nyListAdapterPresenter.bindRow(0, viewHolder);

    }

    @Test
    public void setResult() {
        nyListAdapterPresenter.setResult(nyListResponse);
    }

    @Test
    public void onItemInteract() {
        nyListAdapterPresenter.onItemInteract(0);
    }

    @Test
    public void getListRowCount() {
    }
}