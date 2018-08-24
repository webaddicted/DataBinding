package com.deepaksharma.webaddicted.databinding.ui.recyclerActivity;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


import com.bumptech.glide.Glide;
import com.deepaksharma.webaddicted.databinding.R;
import com.deepaksharma.webaddicted.databinding.databinding.CustomLayoutBinding;

import java.util.List;

/**
 * Created by Deepak Sharma on 06-05-2018.
 */

public class RecyclViewAdapter extends RecyclerView.Adapter<RecyclViewAdapter.RecyclerViewHolder> {
    Context mContext;
    List<ProfileModel> mProfileModelList;
    RecyclerViewModel mRecyclerViewModel;

    public RecyclViewAdapter(Context context, List<ProfileModel> profileModelList, RecyclerViewModel recyclerViewModel) {
        this.mProfileModelList = profileModelList;
        this.mContext = context;
        this.mRecyclerViewModel = recyclerViewModel;
    }

    @NonNull
    @Override
    public RecyclViewAdapter.RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CustomLayoutBinding caBinding = DataBindingUtil.
                inflate(LayoutInflater.from(parent.getContext()),
                        R.layout.custom_layout,
                        parent, false);
        return new RecyclViewAdapter.RecyclerViewHolder(caBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclViewAdapter.RecyclerViewHolder holder, int position) {

        holder.binding.btnCustomClick.setText(mProfileModelList.get(position).getName());
        Glide.with(mContext).load(mProfileModelList.get(position).getImg()).
                placeholder(R.drawable.ic_launcher_background).
                into(holder.binding.imgCustomImg);
        final ProfileModel profileModel = mProfileModelList.get(position);
        holder.binding.setModel(profileModel);
        recyclerView(holder.binding, position);
    }

    private void recyclerView(final CustomLayoutBinding binding, int position) {
    binding.btnCustomClick.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            mRecyclerViewModel.changeData(binding);

        }
    });
    }

    @Override
    public int getItemCount() {
        return mProfileModelList.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        private CustomLayoutBinding binding;
        public RecyclerViewHolder(CustomLayoutBinding itemView) {
            super(itemView.getRoot());
            this.binding = itemView;
        }
    }
}
