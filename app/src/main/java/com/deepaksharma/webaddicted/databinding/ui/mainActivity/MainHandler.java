package com.deepaksharma.webaddicted.databinding.ui.mainActivity;

import android.view.View;

/**
 * Created by deepaksharma on 24/8/18.
 */

public class MainHandler {
    MainClickLinstener mMainClickLinstener;

    public MainHandler(MainClickLinstener mainClickLinstener) {
        this.mMainClickLinstener = mainClickLinstener;
    }
    public void onRecyclerVie(View v){
        mMainClickLinstener.onRecyclerView();
    }
    public void callFragmen(View v){
        mMainClickLinstener.callFragment();
    }
    public void includeLayou(View v){
        mMainClickLinstener.includeLayout();
    }

}
