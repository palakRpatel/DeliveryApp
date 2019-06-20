package com.example.nytimesapp.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nytimesapp.R;
import com.example.nytimesapp.data.NYListResponse;
import com.example.nytimesapp.data.Result;

public class NYListAdapter extends RecyclerView.Adapter<NYListViewHolder> {

    private final NYListAdapterPresenter presenter;

    public NYListAdapter(NYListResponse result) {
        this.presenter = new NYListAdapterPresenter();
        presenter.setResult(result);
    }

    @NonNull
    @Override
    public NYListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new NYListViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.nylist_item, parent, false),presenter);
    }

    @Override
    public void onBindViewHolder(@NonNull NYListViewHolder holder, int position) {
        presenter.bindRow(position, holder);
    }

    @Override
    public int getItemCount() {
        return presenter.getListRowCount();
    }
}
