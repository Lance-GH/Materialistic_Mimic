package com.example.materialisticmimic;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;

import java.util.Objects;

public class AboutActivity extends InjectableActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        setSupportActionBar(findViewById(R.id.toolbar));

        Objects.requireNonNull(getSupportActionBar()).getDisplayOptions() = ActionBar.DISPLAY_SHOW_HOME |
                ActionBar.DISPLAY_HOME_AS_UP | ActionBar.DISPLAY_SHOW_TITLE;

        String versionName = "";
        int versionCode = 0;

        try {
            versionName = getPackageManager().getPackageInfo(getPackageName(), 0).versionName;
            versionCode = getPackageManager().getPackageInfo(getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            // do nothing
        }

        setTextWithLinks(R.id.text_application_info, getString(R.string.application_info_text, versionName, versionCode));
        setTextWithLinks(R.id.text_developer_info, getString(R.string.developer_info_text));
        setTextWithLinks(R.id.text_libraries, getString(R.string.libraries_text));
        setTextWithLinks(R.id.text_license, getString(R.string.license_text));
        setTextWithLinks(R.id.text_3rd_party_licenses, getString(R.string.third_party_licenses_text));
        setTextWithLinks(R.id.text_privacy_policy, getString(R.string.privacy_policy_text));
    }

    private void setTextWithLinks(@IdRes int textViewResId, String htmlText) {
        AppUtils.setTextWithLinks(findViewById(textViewResId), AppUtils.fromHtml(htmlText));
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
