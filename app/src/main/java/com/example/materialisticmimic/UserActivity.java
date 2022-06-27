package com.example.materialisticmimic;

import android.app.Activity;
import android.os.Bundle;

import android.view.KeyEvent;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.example.materialisticmimic.annotation.Synthetic;
import com.example.materialisticmimic.data.ResponseListener;
import com.example.materialisticmimic.data.UserManager;
import com.example.materialisticmimic.widget.TextView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.tabs.TabLayout;

import javax.inject.Inject;
import javax.inject.Named;

public class UserActivity extends InjectableActivity implements Scrollable {
    public static final String EXTRA_USERNAME = UserActivity.class.getName() + ".EXTRA_USERNAME";
    public static final String STATE_USER = "state:user";
    public static final String PARAM_ID = "id";
    public static final String KARMA = " (%1$s)";

    @Inject
    UserManager mUserManager;

    @Inject @Named(ActivityModule.HN) ItemManager mItemManager;

    @Inject KeyDelegate mKeyDelegate;
    private KeyDelegate.RecyclerViewHelper mScrollableHelper;

    private String mUsername;
    private UserManager.User mUser;
    private TextView mTitle;
    private TextView mInfo;
    private TextView mAbout;

    @Synthetic
    RecyclerView mRecyclerView;
    private TabLayout mTabLayout;
    private View mEmpty;
    private BottomSheetBehavior<View> mBottomSheetViewBehavior;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mKeyDelegate.attach(this);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable(STATE_USER, mUser);
    }

    @Override
    protected void onStop() {
        super.onStop();
        mKeyDelegate.detach(this);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        mKeyDelegate.setScrollable(this, null);
        return mKeyDelegate.onKeyDown(keyCode, event) ||
                super.onKeyDown(keyCode, event);
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        return mKeyDelegate.onKeyLongPress(keyCode, event) || super.onKeyUp(keyCode, event);
    }

    @Override
    public boolean onKeyLongPress(int keyCode, KeyEvent event) {
        return super.onKeyLongPress(keyCode, event);
    }

    @Override
    public void scrollToTop() {
        mScrollableHelper.scrollToTop();
    }

    @Override
    public boolean scrollToNext() {
        return mScrollableHelper.scrollToNext();
    }

    @Override
    public boolean scrollToPrevious() {
        return mScrollableHelper.scrollToPrevious();
    }


    private void load() { mUserManager.getUser(mUsername, new UserResponseListener(this)); }

    @Synthetic
    void onUserLoaded(UserManager.User reponse) {

    }

    private void showEmpty() {

    }

    private void bind() {

    }

    static class UserResponseListener implements ResponseListener<UserManager.User> {

        @Override
        public void onResponse(@Nullable UserManager.User response) {

        }

        @Override
        public void onError(String errorMessage) {

        }
    }
}
