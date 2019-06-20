package com.example.nytimesapp.adapter;

import com.example.nytimesapp.data.NYListResponse;
import com.example.nytimesapp.data.Result;

import java.util.List;

public class NYListAdapterPresenter implements NyListAdapterContract.Presenter {

    private List<Result> responseList;
    private NYListViewHolder viewHolder;
    private Result nyListResponse;

    @Override
    public void bindRow(int position, NYListViewHolder viewHolder) {
        nyListResponse = responseList.get(position);
        this.viewHolder = viewHolder;
        this.viewHolder.setTitle(nyListResponse.getTitle());
        this.viewHolder.setDescription(nyListResponse.getByline());
        this.viewHolder.setDate(nyListResponse.getPublishedDate());
    }

    @Override
    public void setResult(NYListResponse result) {
        responseList = result.getResults();
    }

    @Override
    public void onItemInteract(int adapterPosition) {
        viewHolder.navigateDetailActivity(responseList.get(adapterPosition));
    }

    @Override
    public int getListRowCount() {
        return responseList.size();
    }


}
