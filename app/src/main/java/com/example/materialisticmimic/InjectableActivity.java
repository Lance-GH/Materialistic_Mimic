package com.example.materialisticmimic;

import android.os.Bundle;

import androidx.annotation.Nullable;

import dagger.ObjectGraph;

public abstract class InjectableActivity extends ThemedActivity implements Injectable {
    private ObjectGraph mActivityGraph;
    private boolean mDestroyed;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public void inject(Object object) {

    }

    @Override
    public ObjectGraph getApplicationGraph() {
        return null;
    }

    public boolean isActivityDestroyed() {
        return mDestroyed;
    }
}
