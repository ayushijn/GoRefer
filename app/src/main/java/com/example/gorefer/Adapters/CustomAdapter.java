package com.example.gorefer.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gorefer.R;
import com.example.gorefer.databinding.CustomRowBinding;
import com.example.gorefer.model.ApiResponse;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder> {

    private ArrayList<ApiResponse> dataList;
    private Context context;

    public CustomAdapter(Context context, ArrayList<ApiResponse> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {
        CustomRowBinding binding;

        CustomViewHolder(CustomRowBinding binding) {
            super(binding.getRoot());

            this.binding = binding;
        }
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        CustomRowBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.custom_row, parent, false);
        return new CustomViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        holder.binding.tvTittle.setText(dataList.get(position).getTitle());
        holder.binding.tvDesc.setText(dataList.get(position).getBody());

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}