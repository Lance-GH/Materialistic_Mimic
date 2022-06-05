package com.example.materialisticmimic;

import androidx.annotation.StringRes;
import androidx.annotation.VisibleForTesting;

import com.example.materialisticmimic.annotation.PublicApi;

@PublicApi
public class Preferences {

    private static final String DRAFT_PREFIX = "draft_%1$s";
    private static final String PREFERENCES_DRAFT = "_drafts";
    @VisibleForTesting static Boolean sReleaseNotesSeen = null;

    public enum SwipeAction {
        None, Vote, Save, Refresh, Share
    }


    public static class Observable {
        
    }

    public interface Observer {
        void onPreferenceChanged(@StringRes int key, boolean contextChanged);
    }
}
