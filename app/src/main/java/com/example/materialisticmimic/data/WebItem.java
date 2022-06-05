package com.example.materialisticmimic.data;

import android.content.Context;
import android.os.Parcelable;
import android.text.Spannable;

import androidx.annotation.NonNull;
import androidx.annotation.StringDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public interface WebItem extends Parcelable {
    @Retention(RetentionPolicy.SOURCE)
    @StringDef({
            JOB_TYPE,
            STORY_TYPE,
            COMMENT_TYPE,
            POLL_TYPE,
    })
    /*
      Item types
     */
    @interface Type{}
    String JOB_TYPE = "job";
    String STORY_TYPE = "story";
    String COMMENT_TYPE = "comment";
    String POLL_TYPE = "poll";

    /**
     * Gets formatted title to display
     * @return formatted title or null
     */
    String getDisplayedTitle();

    /**
     * Gets item URL to pass to {@link android.webkit.WebView#loadUrl(String)}
     * @return URL or null
     */
    String getUrl();

    /**
     * Checks if the item is not a comment
     * @return true if not a comment, false otherwise
     */
    boolean isStoryType();

    /**
     * Gets item ID string
     * @return item ID string
     */
    String getId();

    /**
     * Gets item ID
     * @return item ID
     */
    long getLongId();

    /**
     * Gets item source
     * @return item source or null
     */
    String getSource();

    /**
     * Gets formatted author for display
     * @param context       an instance of {@link Context}
     * @param linkify       true to display author as a hyperlink, false otherwise
     * @param color         optional decorator color for author, or 0
     * @return  displayed author
     */
    Spannable getDisplayedAuthor(Context context, boolean linkify, int color);

    /**
     * Gets formatted posted time for display
     * @param context   resources provider
     * @return  displayed time
     */
    Spannable getDisplayedTime(Context context);

    /**
     * Gets item type
     * @return item type
     */
    @NonNull
    @Type
    String getType();

    /**
     * Checks if the item is marked as favorite
     * @return true if favorite, false otherwise
     * @see #setFavorite(boolean)
     */
    boolean isFavorite();

    /**
     * Updates item's favorite status to given status
     * @param favorite true if favorite, false otherwise
     * @see #isFavorite()
     */
    void setFavorite(boolean favorite);
}
