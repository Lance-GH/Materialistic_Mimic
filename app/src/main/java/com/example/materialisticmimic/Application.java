package com.example.materialisticmimic;

import android.content.Context;

import com.squareup.leakcanary.RefWatcher;

public class Application {

    private RefWatcher mRefWatcher;

    public static RefWatcher getRefWatcher(Context context) {
        Application application = (Application) context.getApplicationContext();
        return application.mRefWatcher;
    }
}
