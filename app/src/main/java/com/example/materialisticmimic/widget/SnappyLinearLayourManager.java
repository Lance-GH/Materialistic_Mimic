package com.example.materialisticmimic.widget;

import android.content.Context;
import android.graphics.PointF;
import android.util.AttributeSet;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;

import com.example.materialisticmimic.AppUtils;

/**
 * Light extension to {@link LinearLayoutManager} that overrides smooth scroller to
 * always snap to start
 */
public class SnappyLinearLayourManager extends LinearLayoutManager {

    private final int mExtraSpace;

    public SnappyLinearLayourManager(Context context, boolean preload) {
        super(context);
        mExtraSpace = preload ? AppUtils.getDisplayHeight(context) : 0;
    }

    @Override
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int position) {
        RecyclerView.SmoothScroller smoothScroller =
                new LinearSmoothScroller(recyclerView.getContext()) {
                    @Override
                    public PointF computeScrollVectorForPosition(int targetPosition) {
                        return SnappyLinearLayourManager.this
                                .computeScrollVectorForPosition(targetPosition);
                    }

                    @Override
                    protected int getVerticalSnapPreference() {
                        return SNAP_TO_START;
                    }
                };
        smoothScroller.setTargetPosition(position);
        startSmoothScroll(smoothScroller);
    }

    @Override
    protected int getExtraLayoutSpace(RecyclerView.State state) {
        return mExtraSpace == 0 ? super.getExtraLayoutSpace(state) : mExtraSpace;
    }
}
