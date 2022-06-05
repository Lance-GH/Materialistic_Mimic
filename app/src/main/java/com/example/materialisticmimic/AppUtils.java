package com.example.materialisticmimic;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.Html;
import android.text.Layout;
import android.text.Spannable;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.text.style.URLSpan;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.browser.customtabs.CustomTabsSession;

import com.example.materialisticmimic.data.WebItem;

public class AppUtils {

    private final static String ABBR_YEAR = "y";
    private final static String ABBR_WEEK = "w";
    private final static String ABBR_DAY = "d";
    private final static String ABBR_HOUR = "h";
    private final static String ABBR_MINUTE = "m";
    private static final String PLAY_STORE_URL = "market://details?id=" + BuildConfig.APPLICATION_ID;
    private static final String FORMAT_HTML_COLOR = "%06X";
    public static final int HOT_THRESHOLD_HIGH = 300;
    public static final int HOT_THRESHOLD_NORMAL = 100;
    static final int HOT_THRESHOLD_LOW = 10;
    public static final int HOT_FACTOR = 3;
    private static final String HOST_ITEM = "item";
    private static final String HOST_USER = "user";



    public static void openWebUrlExternal(Context context, @Nullable WebItem item, String url, @Nullable CustomTabsSession session) {

    }

    public static void setTextWithLinks(TextView textView, CharSequence html) {
        textView.setText(html);

        textView.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getAction();
                if (action == event.ACTION_UP || action == event.ACTION_DOWN) {
                    int x = (int) event.getX();
                    int y = (int) event.getY();

                    TextView widget = (TextView) v;
                    x -= widget.getTotalPaddingLeft();
                    y -= widget.getTotalPaddingTop();

                    x += widget.getScrollX();
                    y += widget.getScrollY();

                    Layout layout  = widget.getLayout();
                    int line = layout.getLineForVertical(y);
                    int off = layout.getOffsetForHorizontal(line, x);

                    ClickableSpan[] links = Spannable.Factory.getInstance()
                            .newSpannable(widget.getText())
                            .getSpans(off, off, ClickableSpan.class);

                    if (links.length != 0) {
                        if (action == event.ACTION_UP) {
                            if (links[0] instanceof URLSpan) {
                                openWebUrlExternal(widget.getContext(), null,
                                        ((URLSpan) links[0]).getURL(), null);
                            } else {
                                links[0].onClick(widget);
                            }
                        }
                        return true;
                    }
                }
                return false;
            }
        });
    }

    public static CharSequence fromHtml(String htmlText) { return fromHtml(htmlText, false); }

    public static CharSequence fromHtml(String htmlText, boolean compact) {
        if (TextUtils.isEmpty(htmlText)) {
            return null;
        }
        CharSequence spanned;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            //noinspection InlinedApi
            spanned = Html.fromHtml(htmlText, compact ? Html.FROM_HTML_MODE_COMPACT : Html.FROM_HTML_MODE_LEGACY);
        } else {
            //noinspection deprecation
            spanned = Html.fromHtml(htmlText);
        }
        return trim(spanned);
    }

    public static void openPlayStore(Context context) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(PLAY_STORE_URL));
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY |
                Intent.FLAG_ACTIVITY_MULTIPLE_TASK |
                Intent.FLAG_ACTIVITY_NEW_TASK |
                Intent.FLAG_ACTIVITY_NEW_DOCUMENT);

        try {
            context.startActivity(intent);
        } catch (ActivityNotFoundException e) {
            Toast.makeText(context, R.string.no_playstore, Toast.LENGTH_SHORT).show();
        }
    }

    private static CharSequence trim(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            return charSequence;
        }
        int end = charSequence.length() - 1;
        while (Character.isWhitespace(charSequence.charAt(end))) {
            end--;
        }
        return charSequence.subSequence(0, end + 1);
    }

    public static boolean urlEquals(String thisUrl, String thatUrl) {

        return false;
    }
}