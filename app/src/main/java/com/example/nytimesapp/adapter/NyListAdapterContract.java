package com.example.nytimesapp.adapter;

import com.example.nytimesapp.data.NYListResponse;
import com.example.nytimesapp.data.Result;

public class NyListAdapterContract {

    interface View {

        void setTitle(String title);

        void setDate(String title);

        void setAuthor(String author);

        void navigateDetailActivity(Result result);

        void setDescription(String byline);
    }

    interface Presenter {

        int getListRowCount();

        void bindRow(int position, NYListViewHolder viewHolder);

        void setResult(NYListResponse result);

        void onItemInteract(int adapterPosition);
    }
}
