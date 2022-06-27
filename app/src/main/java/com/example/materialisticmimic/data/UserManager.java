package com.example.materialisticmimic.data;

import android.content.Context;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public interface UserManager {

    void getUser(String username, final ResponseListener<User> listener);

    interface User extends Parcelable {
        String getId();
        String getAbout();
        long getKarma();
        String getCreated(Context context);
        @NonNull Item[] getItems();
    }
}
