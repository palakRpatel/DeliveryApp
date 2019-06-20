package com.example.nytimesapp.adapter;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nytimesapp.NYTimesListDetailsActivity;
import com.example.nytimesapp.R;
import com.example.nytimesapp.data.Result;

public class NYListViewHolder extends RecyclerView.ViewHolder implements NyListAdapterContract.View, View.OnClickListener {

    private TextView txtTitle, txtDate, txtDescription;
    private NYListAdapterPresenter nyListAdapterPresenter;

    public NYListViewHolder(@NonNull View itemView, NYListAdapterPresenter presenter) {
        super(itemView);
        txtTitle = itemView.findViewById(R.id.txt_name);
        txtDate = itemView.findViewById(R.id.txt_date);
        txtDescription = itemView.findViewById(R.id.txt_description);
        this.nyListAdapterPresenter = presenter;
        itemView.setOnClickListener(this);
    }


    @Override
    public void setTitle(String title) {
        txtTitle.setText(title);
    }

    @Override
    public void setDate(String date) {
        txtDate.setText(date);
    }

    @Override
    public void setAuthor(String author) {

    }


    @Override
    public void onClick(View view) {
        if (nyListAdapterPresenter != null) {
            nyListAdapterPresenter.onItemInteract(getAdapterPosition());
        }
    }

    @Override
    public void navigateDetailActivity(Result result) {
        Intent intent = new Intent(itemView.getContext(), NYTimesListDetailsActivity.class);
        intent.putExtra("result", result);
        itemView.getContext().startActivity(intent);

    }

    @Override
    public void setDescription(String byline) {
        txtDescription.setText(byline);
    }
}
