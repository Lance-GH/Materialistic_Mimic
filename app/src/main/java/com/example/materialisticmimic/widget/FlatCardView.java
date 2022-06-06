package com.example.materialisticmimic.widget;

import android.content.Context;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;

public class FlatCardView extends CardView {
    public FlatCardView(@NonNull Context context) {
        super(context);
    }

    public FlatCardView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public FlatCardView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void flatten() {
        setRadius(0);
        setUseCompatPadding(false);
        if (getLayoutParams() instanceof MarginLayoutParams) {
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) getLayoutParams();
            marginLayoutParams.leftMargin = getContentPaddingLeft() - getPaddingLeft();
            marginLayoutParams.rightMargin = getContentPaddingRight() - getPaddingRight();
            marginLayoutParams.topMargin = getContentPaddingTop() - getPaddingTop();
            marginLayoutParams.bottomMargin = getContentPaddingBottom() - getPaddingBottom();
        }
    }
}
