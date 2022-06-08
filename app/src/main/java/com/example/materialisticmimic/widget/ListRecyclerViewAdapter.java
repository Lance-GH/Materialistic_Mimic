package com.example.materialisticmimic.widget;

import android.app.AlertDialog;
import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.PopupMenu;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.materialisticmimic.AppUtils;
import com.example.materialisticmimic.CustomTabsDelegate;
import com.example.materialisticmimic.Injectable;
import com.example.materialisticmimic.MultiPaneListener;
import com.example.materialisticmimic.Preferences;
import com.example.materialisticmimic.R;
import com.example.materialisticmimic.data.Item;
import com.example.materialisticmimic.data.WebItem;

import javax.inject.Inject;

/**
 * Base {@link RecyclerView.Adapter} class for list items
 * @param <VH>  view holder type, should contain title, posted, source and comment views
 * @param <T>   item type, should provide title, posted, source
 */
abstract public class ListRecyclerViewAdapter
    <VH extends ListRecyclerViewAdapter.ItemViewHolder, T extends WebItem> extends RecyclerView.Adapter<VH> {

    private static final String STATE_LAST_SELECTION_POSITION = "state:lastSelectedPosition";
    private static final int VIEW_TYPE_CARD = 0;
    private static final int VIEW_TYPE_FLAT = 1;
    private CustomTabsDelegate mCustomTabsDelegate;
    protected Context mContext;
    private MultiPaneListener mMultiPaneListener;
    LayoutInflater mInflater;

    @Inject PopupMenu mPopupMenu;
    @Inject AlertDialogBuilder mAlertDialogBuilder;
    @Inject UserServices mUserServices;
    @Inject FavoriteManager mFavoriteManager;

    private int mLastSelectedPosition = -1;
    private boolean mCardViewEnabled = true;
    private int mHotThreshold = Integer.MAX_VALUE;
    private final Preferences.Observable mPreferenceObservable = new Preferences.Observable();
    private boolean mMultiWindowEnabled;

    public ListRecyclerViewAdapter(Context context) {
        mContext = context;
        mInflater = AppUtils.createLayoutInflator(mContext);
        ((Injectable) mContext).inject(this);
    }

    /**
     * Base {@link RecyclerView.ViewHolder} class for list item view
     */
    public static class ItemViewHolder extends RecyclerView.ViewHolder {
        private final StoryView mStoryView;
        private final FlatCardView mCardView;
        private final int mCardElevation;

        public interface ShowMoreOptionsListener {
            void showMoreOptions(View anchor);
        }

        ItemViewHolder(View itemView) {
            super(itemView);
            mCardView = (FlatCardView) itemView;
            mStoryView = itemView.findViewById(R.id.story_view);
            mCardElevation = itemView.getContext().getResources().getDimensionPixelSize(R.dimen.cardview_elevation);
        }

        public void bind() {

        }

        public void clear() {
            mCardView.setCardElevation(0);
            mStoryView.reset();
            itemView.setOnClickListener(null);
            itemView.setOnLongClickListener(null);
        }

        public void flatten() {
            mCardView.flatten();
        }

        public void animateVote(int score) {
            mStoryView.animateVote(score);
        }

        public void setViewed(boolean viewed) {
            mStoryView.setViewed(viewed);
        }

        public void setFavorite(boolean favorite) {

        }

        public void setUpdated(Item story, boolean updated, int change) {

        }

        public void setChecked(boolean checked) {

        }

        public void setOnLongClickListener(View.OnClickListener longClickListener) {

        }

        public void bindMoreOptions(ShowMoreOptionsListener listener, boolean allowLongClick) {

        }
    }
}
