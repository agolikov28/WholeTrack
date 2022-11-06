package com.example.wholetrack.ui.diet;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class DietViewModel extends ViewModel {

    private final MutableLiveData<String> mText;
    private final MutableLiveData<String> mText2;

    public DietViewModel() {

        mText = new MutableLiveData<>();
        mText.setValue("This is diet fragment.");
        mText2 = new MutableLiveData<>();
        mText2.setValue("Hello");
    }

    public LiveData<String> getText() {
        return mText;
    }
}