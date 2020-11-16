package com.example.gorefer.api;

import com.example.gorefer.model.ApiResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface GetDataService {

    @GET("/posts")
    Call<ArrayList<ApiResponse>> getDataList();

}