package com.example.materialisticmimic;

import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import javax.inject.Inject;

abstract class BaseListFragment extends BaseFragment implements Scrollable {

    private static final String STATE_ADAPTER = "state:adapter";
    @Inject
    CustomTabsDelegate mCustomTabsDelegate;
    private KeyDelegate.RecyclerViewHelper mScrollableHelper;
    protected RecyclerView mRecyclerView;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    private void showPreferences() {

    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
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

    private void onPreferenceChanged(int key, boolean contextChanged) {

    }

    protected abstract ListRecyclerViewAdapter getAdapter();
}
