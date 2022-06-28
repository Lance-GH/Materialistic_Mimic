package com.example.materialisticmimic;

import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/**
 * Base fragment which performs injection using parent's activity object graphs if any
 */
public abstract class BaseFragment extends Fragment {

    protected final MenuTintDelegate mMenutTintDelegate = new MenuTintDelegate();
    private boolean mAttached;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mAttached = true;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getActivity() instanceof Injectable) {
            ((Injectable) getActivity()).inject(this);
        }
        mMenutTintDelegate.onActivityCreated(getActivity());
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        if (isAttached()) {  // TODO http://b.android.com/80783
            createOptionsMenu(menu, inflater);
            mMenutTintDelegate.onOptionsMenuCreated(menu);
        }
    }

    @Override
    public void onPrepareOptionsMenu(@NonNull Menu menu) {
        if (!isAttached()) { // TODO http://b.android.com/80783
            super.onPrepareOptionsMenu(menu);
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mAttached = false;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Application.getRefWatcher(getActivity()).watch(this);
    }

    public boolean isAttached() {
        return mAttached;
    }

    protected void createOptionsMenu(Menu menu, MenuInflater inflater) {
        // override to create options menu
    }

    protected void prepareOptionsMenu(Menu menu) {
        // override to prepare options menu
    }

}
