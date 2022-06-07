package com.example.materialisticmimic;

import android.app.Activity;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.view.KeyEvent;

import androidx.annotation.IntDef;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.appbar.AppBarLayout;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Helper that interprets key events and interprets them into navigation actions
 */
public class KeyDelegate {

    @Retention(RetentionPolicy.SOURCE)
    @IntDef({
            DIRECTION_NONE,
            DIRECTION_UP,
            DIRECTION_DOWN
    })

    @interface Direction {}
    private static final int DIRECTION_NONE = 0;
    private static final int DIRECTION_UP = 1;
    private static final int DIRECTION_DOWN = 2;

    private final SharedPreferences.OnSharedPreferenceChangeListener mPreferenceListener;
    private String mPreferenceKey;
    private boolean mEnabled;
    private Scrollable mScrollable;
    private AppBarLayout mAppBarLayout;
    private boolean mAppBarEnabled = true;
    private BackIntercepter mBackInterceptor;

    public KeyDelegate() {
        mPreferenceListener = (sharedPreferences, key) -> {
            if (TextUtils.equals(key, mPreferenceKey)) {
                mEnabled = sharedPreferences.getBoolean(key, false);
            }
        };
    }


    public void attach(Activity activity) {

    }


    public void detach(Activity activity) {

    }

    public void setScrollable(Scrollable scrollable, AppBarLayout appBarLayout) {

    }

    void setAppBarEnabled(boolean enabled) {

    }

    void setBackInterceptor(BackInterceptor backInterceptor) {

    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {

        return false;
    }

    public boolean onKeyUp(int keyCode, KeyEvent event) {

        return false;
    }

    public boolean onKeyLongPress(int keyCode, KeyEvent event) {

        return false;
    }

    private void shortPress(@Direction int direction) {

    }

    private void longPress(@Direction int direction) {

    }

    /**
     * Helper class to navigate vertical RecyclerView
     */
    static class RecyclerViewHelper implements Scrollable {

        @Retention(RetentionPolicy.SOURCE)
        @IntDef({
                SCROLL_ITEM,
                SCROLL_PAGE
        })
        @interface ScrollMode {}
        static final int SCROLL_ITEM = 0;
        static final int SCROLL_PAGE = 1;

        private final RecyclerView mRecyclerView;
        private final @ScrollMode int mScrollMode;
        private boolean mSmoothScroll = true;

        RecyclerViewHelper(RecyclerView recyclerView, @ScrollMode int scrollMode) {
            mRecyclerView = recyclerView;
            if (!(mRecyclerView.getLayoutManager() instanceof LinearLayoutManager)) {
                throw new IllegalArgumentException("Only LinearLayoutManager supported");
            }
            mScrollMode = scrollMode;
        }

        @Override
        public void scrollToTop() {

        }

        @Override
        public boolean scrollToNext() {
            return false;
        }

        @Override
        public boolean scrollToPrevious() {
            return false;
        }
    }
}
