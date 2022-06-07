package com.example.materialisticmimic;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;

import com.example.materialisticmimic.widget.ListRecyclerViewAdapter;
import com.example.materialisticmimic.widget.StoryRecyclerViewAdapter;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

public class ListFragment extends BaseListFragment {

    private static final String EXTRA_ITEM_MANAGER = ListFragment.class.getName() + ".EXTRA_ITEM_MANAGER";
    public static final String EXTRA_FILTER = ListFragment.class.getName() + ".EXTRA_FILTER";
    private static final String STATE_FILTER = "state:filter";
    private static final String STATE_CACHE_MODE = "state:cacheMode";

    private final Preferences.Observable mPreferenceObservable = new Preferences.Observable();

    private final Observer<Uri> mObserver = uri -> {
        if (uri == null) {
            return;
        }
        int toastMessageResId = 0;
        if (FavoriteManager.Companion.isAdded(uri)) {
            toastMessageResId = R.string.toast_saved;
        } else if (FavoriteManager.Companion.isRemoved(uri)) {
            toastMessageResId = R.string.toast_removed;
        }

        if (toastMessageResId == 0) {
            return;
        }

        Snackbar.make(mRecyclerView, toastMessageResId, Snackbar.LENGTH_SHORT)
                .setAction("Undo", v -> getAdapter().toggleSave(uri.getLastPathSegment()))
                .show();
    };

    private StoryRecyclerViewAdapter mAdapter;


    public interface RefreshCallback {
        void onRefreshed();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    public void filter(String filter) {

    }

    @Override
    protected StoryRecyclerViewAdapter getAdapter() {

    }

    private void onPreferenceChanged(int key, boolean contextChanged) {

    }

    private void refresh() {

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

    @Override
    protected ListRecyclerViewAdapter getAdapter() {
        return null;
    }
}
