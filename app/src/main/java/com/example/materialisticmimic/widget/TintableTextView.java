package com.example.materialisticmimic.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;

import com.example.materialisticmimic.AppUtils;
import com.example.materialisticmimic.R;

public class TintableTextView extends AppCompatTextView {

    private int mTextColor;

    public TintableTextView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TintableTextView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mTextColor = getTextColor(context, attrs);
        TypedArray ta = context.getTheme().obtainStyledAttributes(
                attrs, R.styleable.TintableTextView, 0, 0);
        setCompoundDrawablesWithIntrinsicBounds(
                ta.getDrawable(R.styleable.TintableTextView_iconStart),
                ta.getDrawable(R.styleable.TintableTextView_iconTop),
                ta.getDrawable(R.styleable.TintableTextView_iconEnd),
                ta.getDrawable(R.styleable.TintableTextView_iconBottom));
    }

    public void setCompoundDrawablesWithIntrinsicBounds(Drawable left, Drawable top, Drawable right, Drawable bottom) {
        super.setCompoundDrawablesWithIntrinsicBounds(tint(left), tint(top), tint(right), tint(bottom));
    }

    public void setTextColor(int color) {
        mTextColor = color;
        super.setTextColor(color);
        Drawable[] drawables = getCompoundDrawables();
        setCompoundDrawablesWithIntrinsicBounds(drawables[0], drawables[1], drawables[2], drawables[3]);
    }

    private int getTextColor(Context context, AttributeSet attrs) {
        int defaultTextColor = ContextCompat.getColor(getContext(),
                AppUtils.getThemedResId(getContext(), android.R.attr.textColorTertiary));
        TypedArray ta = context.obtainStyledAttributes(attrs, new int[]{android.R.attr.textAppearance, android.R.attr.textColor});
        int ap = ta.getResourceId(0, 0);
        int textColor;
        if (ap == 0) {
            textColor = ta.getColor(1, defaultTextColor);
        } else {
            TypedArray tap = context.obtainStyledAttributes(ap, new int[]{android.R.attr.textColor});
            textColor = tap.getColor(0, defaultTextColor);
            tap.recycle();
        }
        ta.recycle();
        return textColor;
    }

    private Drawable tint(@Nullable Drawable drawable) {
        if (drawable == null) {
            return null;
        }
        drawable = DrawableCompat.wrap(drawable);
        DrawableCompat.setTint(drawable, mTextColor);
        return drawable;
    }
}
