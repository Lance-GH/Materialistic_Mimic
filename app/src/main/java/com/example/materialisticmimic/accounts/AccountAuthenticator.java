package com.example.materialisticmimic.accounts;

import android.content.Context;
import android.os.Bundle;

public class AccountAuthenticator extends EmptyAccountAuthenticator {

    private final Context mContext;

    public AccountAuthenticator(Context context) {
        super(context);
        mContext = context;
    }

    public Bundle addAccount() {

    }
}
