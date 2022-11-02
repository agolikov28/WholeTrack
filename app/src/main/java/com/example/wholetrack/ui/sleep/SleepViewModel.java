package com.example.wholetrack.ui.sleep;

import android.os.Bundle;
import android.widget.Button;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.example.wholetrack.R;


public class SleepViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public SleepViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("No chart data available.");
    }



    public LiveData<String> getText() {
        return mText;
    }
}