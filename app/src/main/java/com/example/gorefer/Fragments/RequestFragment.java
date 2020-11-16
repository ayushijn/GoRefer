package com.example.gorefer.Fragments;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.example.gorefer.Adapters.CustomAdapter;
import com.example.gorefer.R;
import com.example.gorefer.api.GetDataService;
import com.example.gorefer.databinding.FragmentRequestBinding;
import com.example.gorefer.model.ApiResponse;
import com.example.gorefer.retrofit.RetrofitClientInstance;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;


public class RequestFragment extends Fragment {
    private FragmentRequestBinding binding;
    ProgressDialog progressDoalog;
    CustomAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_request, container, false);
        getData();
        return binding.getRoot();
    }

    private void getData() {
        progressDoalog = new ProgressDialog(getActivity());
        progressDoalog.setMessage("Loading....");
        progressDoalog.show();

        /*Create handle for the RetrofitInstance interface*/
        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        Call<ArrayList<ApiResponse>> call = service.getDataList();
        call.enqueue(new Callback<ArrayList<ApiResponse>>() {
            @Override
            public void onResponse(Call<ArrayList<ApiResponse>> call, retrofit2.Response<ArrayList<ApiResponse>> response) {
                progressDoalog.dismiss();
                generateDataList(response.body());
            }

            @Override
            public void onFailure(Call<ArrayList<ApiResponse>> call, Throwable t) {
                progressDoalog.dismiss();
                Toast.makeText(getActivity(), "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    /*Method to generate List of data using RecyclerView with custom adapter*/
    private void generateDataList(ArrayList<ApiResponse> dataList) {
        adapter = new CustomAdapter(getActivity(), dataList);
        binding.rcData.setAdapter(adapter);

    }
}