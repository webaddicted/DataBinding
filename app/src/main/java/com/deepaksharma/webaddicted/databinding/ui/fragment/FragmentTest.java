package com.deepaksharma.webaddicted.databinding.ui.fragment;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.deepaksharma.webaddicted.databinding.R;
import com.deepaksharma.webaddicted.databinding.databinding.FragmentFragmentTestBinding;

public class FragmentTest extends Fragment implements View.OnClickListener {
    FragmentFragmentTestBinding testBinding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        testBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_fragment_test, container, false);
//        parent view model can used here
        testBinding.btnClick.setOnClickListener(this);
        return testBinding.getRoot();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_Click:
                Toast.makeText(getContext(), "Fragment click.", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
