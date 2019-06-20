package com.example.nytimesapp.remote;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.nytimesapp.repository.NYTimeListDataSource;
import com.example.nytimesapp.data.NYListResponse;
import com.google.gson.Gson;

public class NYTimeListRemoteDataSource extends NYTimeListDataSource {

    private static NYTimeListRemoteDataSource INSTANCE;
    private final String URL = "https://api.nytimes.com/svc/mostpopular/v2/mostviewed/all-sections/7.json?api-key=bhe4wls5GANyV6iC8xU9Id2xXizuhMk3";
    private StringRequest stringRequest;
    private RequestQueue requestQueue;

    private NYTimeListRemoteDataSource(RequestQueue requestQueue) {
        this.requestQueue = requestQueue;
    }

    public static NYTimeListRemoteDataSource getInstance(RequestQueue requestQueue) {

        if (INSTANCE == null) {
            INSTANCE = new NYTimeListRemoteDataSource(requestQueue);
        }
        return INSTANCE;
    }

    @Override
    public void getNYList(final dataResult dataResultListener) {
        stringRequest = new StringRequest(Request.Method.GET, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();
                NYListResponse nyListResponse = gson.fromJson(response, NYListResponse.class);
                dataResultListener.onSuccess(nyListResponse);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                dataResultListener.onFailure(error.getMessage());
            }
        });
        requestQueue.add(stringRequest);
    }
}
