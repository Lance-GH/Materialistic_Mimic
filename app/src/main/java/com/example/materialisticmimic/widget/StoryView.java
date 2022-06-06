package com.example.materialisticmimic.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Checkable;
import android.widget.RelativeLayout;
import android.widget.ViewSwitcher;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;

import com.example.materialisticmimic.AppUtils;
import com.example.materialisticmimic.R;
import com.example.materialisticmimic.annotation.Synthetic;
import com.example.materialisticmimic.data.Item;
import com.example.materialisticmimic.data.WebItem;

public class StoryView extends RelativeLayout implements Checkable {

    private static final int VOTE_DELAY_MILLIS = 500;
    private static final String PROMOTED = "+%1$d";

    // Textual Colours
    private final int mBackgroundColor;
    private final int mHighlightColor;
    private final int mTertiaryTextColorResId;
    private final int mSecondaryTextColorResId;
    private final int mPromotedColorResId;
    private final int mHotColorResId;
    private final int mAccentColorResId;

    final TextView mRankTextView;
    @Synthetic final TextView mScoreTextView;
    private final View mBookMarked;
    private final TextView mPostedTextView;
    private final TextView mTitleTextView;
    private final TextView mSourceTextView;
    private final TextView mCommentButton;

    private final boolean mIsLocal;

    // ViewSwitcher?
    @Synthetic final ViewSwitcher mVoteSwitcher;

    private final View mMoreButton;
    private final Drawable mCommentDrawable;
    private final View mBackground;
    private boolean mChecked;

    public StoryView(Context context) {
        this(context, null);
    }

    public StoryView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public StoryView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.StoryView);
        mIsLocal = ta.getBoolean(R.styleable.StoryView_local, false);
        TypedArray a = context.getTheme().obtainStyledAttributes(new int[]{
                android.R.attr.textColorTertiary,
                android.R.attr.textColorSecondary,
                R.attr.colorCardBackground,
                R.attr.colorCardHighlight
        });
        mTertiaryTextColorResId = ContextCompat.getColor(context, a.getResourceId(0, 0));
        mSecondaryTextColorResId = ContextCompat.getColor(context, a.getResourceId(1, 0));
        mBackgroundColor = ContextCompat.getColor(context, a.getResourceId(2, 0));
        mHighlightColor = ContextCompat.getColor(context, a.getResourceId(3, 0));
        mPromotedColorResId = ContextCompat.getColor(context, R.color.greenA700);
        mHotColorResId = ContextCompat.getColor(context, R.color.orange500);
        mAccentColorResId = ContextCompat.getColor(getContext(),
                AppUtils.getThemedResId(getContext(), R.attr.colorAccent));

        mCommentDrawable = DrawableCompat.wrap(ContextCompat.getDrawable(context, R.drawable.ic_comment_white_24dp).mutate());
        DrawableCompat.setTint(mCommentDrawable, mAccentColorResId);

        inflate(context, mIsLocal ? R.layout.local_story_view : R.layout.story_view, this);

        mBackground = findViewById(R.id.background);
        mBackground.setBackgroundColor(mBackgroundColor);

        mVoteSwitcher = findViewById(R.id.vote_switcher);
        mRankTextView = findViewById(R.id.rank);
        mScoreTextView = findViewById(R.id.score);
        mBookMarked = findViewById(R.id.bookmarked);
        mPostedTextView = findViewById(R.id.posted);
        mTitleTextView = findViewById(R.id.title);
        mSourceTextView = findViewById(R.id.source);
        mCommentButton = findViewById(R.id.comment);
        mCommentButton.setCompoundDrawablesWithIntrinsicBounds(mCommentDrawable, null, null, null);
        mMoreButton = findViewById(R.id.button_more);
        // replace with bounded ripple as unbounded ripple requires container bg
        // http://b.android.com/155880
        mMoreButton.setBackgroundResource(AppUtils.getThemedResId(context,
                R.attr.selectableItemBackground));

        ta.recycle();
        a.recycle();
    }

    @Override
    public void setChecked(boolean checked) {
        if (mChecked == checked) {
            return;
        }
        mChecked = checked;
        mBackground.setBackgroundColor(mChecked ? mHighlightColor : mBackgroundColor);
    }

    @Override
    public boolean isChecked() {
        return mChecked;
    }

    @Override
    public void toggle() {
        setChecked(!mChecked);
    }

    public void setStory(@NonNull WebItem story, int hotThreshold) {
        if (!mIsLocal && story instanceof Item) {

        }
    }

    public void reset() {

    }

    public void setViewed() {

    }

    public void setPromoted(int change) {

    }

    public void setFavorite(boolean isFavorite) {

    }

    public void setOnCommentClickListener(View.OnClickListener listener) {

    }

    public void setUpdated(@NonNull Item story, boolean updated, int change) {

    }

    void animateVote(final int newScore) {

    }

    public View getMoreOptions() {
        return mMoreButton;
    }

    private Spannable decorateUpdated() {

    }
}
