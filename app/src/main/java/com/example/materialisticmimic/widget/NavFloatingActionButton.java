package com.example.materialisticmimic.widget;

import android.content.Context;
import android.os.Vibrator;
import android.util.AttributeSet;
import android.view.ViewTreeObserver;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.materialisticmimic.Navigable;
import com.example.materialisticmimic.Preferences;
import com.example.materialisticmimic.annotation.Synthetic;
import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class NavFloatingActionButton extends FloatingActionButton implements ViewTreeObserver.OnGlobalLayoutListener {

    private static final String PREFERENCES_FAB = "_fab";
    private static final String PREFERENCES_FAB_X = "%1$s_%2$d_%3$d_x";
    private static final String PREFERENCES_FAB_Y = "%1$s_%2$d_%3$d_y";
    private static final long VIBRATION_DURATION_MS = 15;
    private static final int DOUBLE_TAP = -1;

    private static final int[] KONAMI_CODE = {
            Navigable.DIRECTION_UP,
            Navigable.DIRECTION_UP,
            Navigable.DIRECTION_DOWN,
            Navigable.DIRECTION_DOWN,
            Navigable.DIRECTION_LEFT,
            Navigable.DIRECTION_RIGHT,
            Navigable.DIRECTION_LEFT,
            Navigable.DIRECTION_RIGHT,
            DOUBLE_TAP
    };

    @Synthetic
    final Vibrator mVibrator;
    private final Preferences.Observable mPreferenceObservable = new Preferences.Observable();

    public NavFloatingActionButton(@NonNull Context context) {
        super(context);
    }

    public NavFloatingActionButton(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public NavFloatingActionButton(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void onGlobalLayout() {

    }
}
