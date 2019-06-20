package com.example.nytimesapp;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.nytimesapp.data.Result;

public class NYTimesListDetailsActivity extends AppCompatActivity {

    private TextView txtTitle, txtDescription, txtDate, txtAuthor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ny_detailactivity);
        Result result = (Result) getIntent().getSerializableExtra("result");
        txtTitle = findViewById(R.id.txt_ny_title);
        txtDescription = findViewById(R.id.txt_ny_description);
        txtDate = findViewById(R.id.txt_ny_date);
        txtAuthor = findViewById(R.id.txt_ny_author);

        txtTitle.setText(result.getTitle());
        txtDescription.setText(result.getByline());
        txtDate.setText(result.getPublishedDate());
        txtAuthor.setText(result.getAbstract());

    }

}
