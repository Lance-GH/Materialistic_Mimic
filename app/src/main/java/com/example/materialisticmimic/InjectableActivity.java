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
        inject(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mDestroyed = true;
        mActivityGraph = null;
    }

    @Override
    public void onBackPressed() {
        try {
            super.onBackPressed();
        } catch (IllegalStateException e) {
            supportFinishAfterTransition();
        }
    }

    @Override
    public void inject(Object object) {
        getApplicationGraph().inject(object);
    }

    @Override
    public ObjectGraph getApplicationGraph() {
        if (mActivityGraph == null) {
            mActivityGraph = ((Injectable) getApplication()).getApplicationGraph()
                    .plus(new ActivityModule(this), new UiModule());
        }

        return mActivityGraph;
    }

    public boolean isActivityDestroyed() {

        return mDestroyed;
    }
}
