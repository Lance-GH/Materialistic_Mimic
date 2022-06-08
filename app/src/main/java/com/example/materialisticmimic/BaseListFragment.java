package com.example.materialisticmimic;

import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.example.materialisticmimic.widget.ListRecyclerViewAdapter;

import javax.inject.Inject;

abstract class BaseListFragment extends BaseFragment implements Scrollable {

    private static final String STATE_ADAPTER = "state:adapter";
    @Inject
    CustomTabsDelegate mCustomTabsDelegate;
    private KeyDelegate.RecyclerViewHelper mScrollableHelper;
    protected RecyclerView mRecyclerView;
    private final Preferences.Observable mPreferenceObservable = new Preferences.Observable();

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mRecyclerView.setLayoutManager(new SnappyLinearLayoutManager(getActivity(), false));
        final int verticalMargin = getResources().getDimensionPixelSize(R.dimen.cardview_vertical_margin);
        final int horizontalMargin = getResources().getDimensionPixelSize(R.dimen.cardview_horizontal_margin);
        final int divider = getResources().getDimensionPixelSize(R.dimen.divider);

        mRecyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
        });
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
