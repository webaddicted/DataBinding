package com.deepaksharma.webaddicted.databinding.ui.recyclerActivity;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.deepaksharma.webaddicted.databinding.R;

/**
 * Created by deepaksharma on 28/5/18.
 */

public class CustomImageView {
    @BindingAdapter({"bind:img"})
    public static void loadImage(ImageView imageView, String url){
        Glide.with(imageView.getContext()).load(url).error(R.drawable.deepak).
                placeholder(R.drawable.deepak).into(imageView);
    }
}
