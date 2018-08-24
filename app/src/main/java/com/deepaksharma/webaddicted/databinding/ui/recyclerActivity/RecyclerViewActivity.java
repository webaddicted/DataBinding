package com.deepaksharma.webaddicted.databinding.ui.recyclerActivity;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.deepaksharma.webaddicted.databinding.R;
import com.deepaksharma.webaddicted.databinding.databinding.ActivityRecyclerViewBinding;
import com.deepaksharma.webaddicted.databinding.ui.mainActivity.MainActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class RecyclerViewActivity extends AppCompatActivity {
    ActivityRecyclerViewBinding recyclerViewBinding;
    RecyclerViewModel recyclerViewModel;
    List<ProfileModel> profileModelList = new ArrayList<>();
    RecyclViewAdapter recyclViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        recyclerViewBinding = DataBindingUtil.setContentView(this, R.layout.activity_recycler_view);
        recyclerViewModel = ViewModelProviders.of(this).get(RecyclerViewModel.class);

        recyclViewAdapter = new RecyclViewAdapter(this, profileModelList, recyclerViewModel);
        recyclerViewBinding.recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        recyclerViewModel.getLoginResponse().observe(this, new Observer<List<ProfileModel>>() {
            @Override
            public void onChanged(@Nullable List<ProfileModel> profileModels) {
                recyclerViewBinding.recyclerView.setHasFixedSize(true);
                profileModelList.addAll(profileModels);
                recyclerViewBinding.recyclerView.setAdapter(recyclViewAdapter);
                Toast.makeText(RecyclerViewActivity.this, "" + profileModelList.size(), Toast.LENGTH_SHORT).show();
            }
        });

        recyclerViewModel.setData();

        recyclerViewBinding.recyclerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RecyclerViewActivity.this, MainActivity.class));
            }
        });
    }

//    public class MyCounter extends CountDownTimer {
//
//        public MyCounter(long millisInFuture, long countDownInterval) {
//            super(millisInFuture, countDownInterval);
//        }
//
//        @Override
//        public void onFinish() {
//            Log.d("timer", "onFinish: ");
//        }
//
//        @Override
//        public void onTick(long millisUntilFinished) {
//            Log.d("timer", "onTick: ");
//
//        }
//    }
}
