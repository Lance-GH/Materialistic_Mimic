package com.example.materialisticmimic;

import android.accounts.AccountAuthenticatorActivity;
import android.os.Bundle;

public class LoginActivity extends AccountAuthenticatorActivity {
    public static final String EXTRA_ADD_ACCOUNT = LoginActivity.class.getName() + ".EXTRA_ADD_ACCOUNT";

    @Override
    protected void onCreate(Bundle icicle) {
        super.onCreate(icicle);
    }

    @Override
    protected boolean isDialogTheme() {

        return true;
    }
}
