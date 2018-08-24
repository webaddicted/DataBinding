package com.deepaksharma.webaddicted.databinding.ui.recyclerActivity;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.os.Handler;

import com.deepaksharma.webaddicted.databinding.databinding.CustomLayoutBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by deepaksharma on 24/8/18.
 */

public class RecyclerViewModel extends ViewModel {
    private MutableLiveData<List<ProfileModel>> profileMtableLive;

    LiveData<List<ProfileModel>> getLoginResponse() {
        if (profileMtableLive == null) {
            profileMtableLive = new MutableLiveData<>();
        }
        return profileMtableLive;
    }

    public synchronized void setData() {
        List<ProfileModel> profileModels = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            profileModels.add(new ProfileModel(
                    "Deepak  - ", "28 yrs", "nice guy,",
                    "https://i.pinimg.com/originals/a4/b0/c0/a4b0c077730f8f5cc6757cf054cbbe55.jpg"));
        }
        profileMtableLive.setValue(profileModels);
    }

    public void changeData(CustomLayoutBinding binding) {
        binding.btnCustomClick.setText("Deepak");

    }
}
