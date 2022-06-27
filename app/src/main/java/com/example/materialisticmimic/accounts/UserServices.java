package com.example.materialisticmimic.accounts;

import android.content.Context;
import android.net.Uri;

import androidx.annotation.StringRes;

import java.io.IOException;

public interface UserServices {
    abstract class Callback {
        public void onDone(boolean successful) {}
        public void onError(Throwable throwable) {}
    }

    class Exception extends IOException {
        public final @StringRes int message;
        public Uri data;

        public Exception(int message) { this.message = message; }

        Exception(String message) {
            super(message);
            this.message = 0;
        }
    }

    void login(String username, String password, boolean createAccount, Callback callback);

    boolean voteUp(Context context, String itemId, Callback callback);

    void reply(Context context, String parentId, String text, Callback callback);

    void submit(Context context, String title, String content, boolean isUrl, Callback callback);
}