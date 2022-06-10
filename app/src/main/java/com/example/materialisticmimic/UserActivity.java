package com.example.materialisticmimic;

import android.app.Activity;
import android.os.UserManager;

import com.example.materialisticmimic.widget.TextView;

import javax.inject.Inject;
import javax.inject.Named;

public class UserActivity extends InjectableActivity implements Scrollable {
    public static final String EXTRA_USERNAME = UserActivity.class.getName() + ".EXTRA_USERNAME";
    public static final String STATE_USER = "state:user";
    public static final String PARAM_ID = "id";
    public static final String KARMA = " (%1$s)";

    @Inject UserManager mUserManager;

    @Inject @Named(ActivityModule.HN) ItemManager mItemManager;

    @Inject KeyDelegate mKeyDelegate;
    private KeyDelegate.RecyclerViewHelper mScrollableHelper;

    private String mUsername;
    private UserManager.User mUser;
    private TextView mTitle;
    private TextView mInfo;
    private TextView mAbout;


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
