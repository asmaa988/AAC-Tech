/*
 * Team-Name: AAC-Tech

 */
package com.example.aac_tech.ui.notifications;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class NotificationsViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public NotificationsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Completed Emergency Scenarios");
    }

    public LiveData<String> getText() {
        return mText;
    }
}