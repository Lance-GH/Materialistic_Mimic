package com.example.materialisticmimic;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import androidx.annotation.VisibleForTesting;

import com.example.materialisticmimic.annotation.PublicApi;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@PublicApi
public class Preferences {

    private static final String DRAFT_PREFIX = "draft_%1$s";
    private static final String PREFERENCES_DRAFT = "_drafts";
    @VisibleForTesting static Boolean sReleaseNotesSeen = null;

    public enum SwipeAction {
        None, Vote, Save, Refresh, Share
    }

    public static boolean navigationVibrationEnabled(Context context) {
        return get(context, R.string.pref_navigation_vibrate, true);
    }

    static boolean get(Context context, @StringRes int key, boolean defaultValue) {
        return PreferenceManager.getDefaultSharedPreferences(context)
                .getBoolean(context.getString(key), defaultValue);
    }

    public static class Observable {
        Set<String> CONTEXT_KEYS;
        Map<String, Integer> mSubscribedKeys = new HashMap<>();
        private final SharedPreferences.OnSharedPreferenceChangeListener mListener = (sharedPreferences, key) -> {
            if (mSubscribedKeys.containsKey(key)) {
                notifyChanged(mSubscribedKeys.get(key), CONTEXT_KEYS.contains(key));
            }
        };
        private Observer mObserver;

        public void subscribe(Context context, @NonNull Observer observer, @NonNull int... preferenceKeys) {
            ensureContextKeys(context);
            setSubscription(context, preferenceKeys);
            mObserver = observer;
            PreferenceManager.getDefaultSharedPreferences(context)
                    .registerOnSharedPreferenceChangeListener(mListener);
        }

        public void unsubscribe(Context context) {
            PreferenceManager.getDefaultSharedPreferences(context)
                    .registerOnSharedPreferenceChangeListener(mListener);
        }

        private void setSubscription(Context context, int[] preferenceKeys) {

        }

        private void notifyChanged(int key, boolean contextChanged) {
            if (mObserver != null) {
                mObserver.onPreferenceChanged(key, contextChanged);
            }
        }

        @SuppressLint("UseSparseArrays")
        private void ensureContextKeys(Context context) {
            if (CONTEXT_KEYS != null) {
                return;
            }
            CONTEXT_KEYS = new HashSet<>();
            CONTEXT_KEYS.add(context.getString(R.string.pref_theme));
            CONTEXT_KEYS.add(context.getString(R.string.pref_text_size));
            CONTEXT_KEYS.add(context.getString(R.string.pref_font));
            CONTEXT_KEYS.add(context.getString(R.string.pref_daynight_auto));
        }
    }

    public interface Observer {
        void onPreferenceChanged(@StringRes int key, boolean contextChanged);
    }
}
