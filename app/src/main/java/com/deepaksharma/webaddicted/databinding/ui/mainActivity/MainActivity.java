package com.deepaksharma.webaddicted.databinding.ui.mainActivity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.deepaksharma.webaddicted.databinding.R;
import com.deepaksharma.webaddicted.databinding.databinding.ActivityMainBinding;
import com.deepaksharma.webaddicted.databinding.ui.fragment.FragmentTest;
import com.deepaksharma.webaddicted.databinding.ui.recyclerActivity.RecyclerViewActivity;

public class MainActivity extends AppCompatActivity implements MainClickLinstener, View.OnClickListener {
    ActivityMainBinding mainBinding;
    MainViewModel mainViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mainBinding.setHandler(new MainHandler(this));
        mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);

        mainBinding.customInculde.imgCustomImg.setOnClickListener(this);
        mainBinding.customInculde.btnCustomClick.setOnClickListener(this);
    }

    @Override
    public void onRecyclerView() {
        startActivity(new Intent(this, RecyclerViewActivity.class));
    }

    @Override
    public void callFragment() {
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragment_Container, new FragmentTest(), "fragment")
                .addToBackStack("Test Fragment")
                .commit();
    }

    @Override
    public void includeLayout() {
        Toast.makeText(this, "include layout ", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.img_customImg:
                Toast.makeText(this, "Image Click ", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_customClick:
                Toast.makeText(this, "Custom Click ", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
