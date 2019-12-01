package com.e.myapplication.ui.mybooks;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MybooksViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public MybooksViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("ahjhj test thoi");
    }

    public LiveData<String> getText() {
        return mText;
    }
}