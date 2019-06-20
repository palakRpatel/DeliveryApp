package com.example.nytimesapp;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.android.volley.toolbox.Volley;
import com.example.nytimesapp.adapter.NYListAdapter;
import com.example.nytimesapp.data.NYListResponse;
import com.example.nytimesapp.repository.NYTimeListRepository;
import com.example.nytimesapp.remote.NYTimeListRemoteDataSource;

public class NYTimesListActivity extends AppCompatActivity implements NYTimesListContract.View {

    private RecyclerView recyclerView;
    private NYTimesListContract.Presenter presenter;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nytimes_list_activity);

//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar)toolbar;
        NYTimeListRepository nyTimeListRepository = NYTimeListRepository.getInstance(NYTimeListRemoteDataSource.getInstance(Volley.newRequestQueue(this)));
        presenter = new NYTimesListPresenter(this, nyTimeListRepository);
    }

    @Override
    public void init() {
        recyclerView = findViewById(R.id.recyler_nytimes);
        progressDialog=new ProgressDialog(this);
        presenter.callNYListRepostitory();
    }

    @Override
    public void setPresenter(NYTimesListContract.Presenter presenter) {
        this.presenter = presenter;
        presenter.start();
    }

    @Override
    public void setAdapter(NYListResponse nyListResponse) {
        NYListAdapter nyListAdapter = new NYListAdapter(nyListResponse);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(nyListAdapter);
    }

    @Override
    public void showProgressDialog(){
        progressDialog.show();
    }

    @Override
    public void hideProgressDialog(){
        progressDialog.hide();
    }
}
