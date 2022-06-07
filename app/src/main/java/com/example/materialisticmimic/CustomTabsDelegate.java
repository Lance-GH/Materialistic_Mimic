package com.example.materialisticmimic;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.browser.customtabs.CustomTabsClient;
import androidx.browser.customtabs.CustomTabsServiceConnection;
import androidx.browser.customtabs.CustomTabsSession;

import com.example.materialisticmimic.annotation.Synthetic;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class CustomTabsDelegate {
    private static final String ACTION_CUSTOM_TABS_CONNECTION = "android.support.customtabs.action.CustomTabsService";
    private CustomTabsSession mCustomTabsSession;
    private CustomTabsClient mClient;
    private CustomTabsServiceConnection mConnection;

    void bindCustomTabsService(Activity activity) {
        if (mClient != null) {
            return;
        }
        if (TextUtils.isEmpty(getPackageNameToUse(activity))) {
            return;
        }
        mConnection = new ServiceConnection(this);
        CustomTabsClient.bindCustomTabsService(activity, getPackageNameToUse(activity), mConnection);
    }


    void unbindCustomTabsService(Activity activity) {
        if (mConnection == null) {
            return;
        }
        activity.unbindService(mConnection);
        mClient = null;
        mCustomTabsSession = null;
        mConnection = null;
    }

    /**
     * @return  true if call to mayLaunchUrl was accepted
     * @see CustomTabsSession#mayLaunchUrl(Uri, Bundle, List)
     */
    public boolean mayLaunchUrl(Uri uri, Bundle extras, List<Bundle> otherLikelyBundles) {
        if (mClient == null) {
            return false;
        }
        CustomTabsSession session = getSession();
        return session != null && session.mayLaunchUrl(uri, extras, otherLikelyBundles);
    }

    /**
     * Creates or retrieves an existing CustomTabsSession
     *
     * @return  a CustomTabsSession
     */
    CustomTabsSession getSession() {
        if (mClient == null) {
            mCustomTabsSession = null;
        } else if (mCustomTabsSession == null) {
            mCustomTabsSession = mClient.newSession(null);
        }
        return mCustomTabsSession;
    }

    @Synthetic
    void onServiceConnected(CustomTabsClient client) {
        mClient = client;
        mClient.warmup(0L);
    }

    @Synthetic
    void onServiceDisconnected() {
        mClient = null;
        mCustomTabsSession = null;
    }

    @Nullable
    private String getPackageNameToUse(Context context) {
        List<String> browsersWithCustomTabsSupport = getBrowsersWithCustomTabsSupport(context);
        String defaultBrowser = getDefaultBrowser(context);

        for (String browser : browsersWithCustomTabsSupport) {
           if (TextUtils.equals(browser, defaultBrowser)) {
               return browser;
           }
        }

        if (browsersWithCustomTabsSupport.isEmpty()) {
            return null;
        }

        return browsersWithCustomTabsSupport.get(0);
    }


    /**
     * Return all browsers that support custom tabs
     *
     * @param context
     * @return List of all Packages with custom Tabs support
     */
    private static List<String> getBrowsersWithCustomTabsSupport(Context context) {
        List<String> packagesSupportCustomTabs = new ArrayList<>();
        PackageManager pm = context.getPackageManager();
        List<ResolveInfo> resolvedActivityList = pm.queryIntentActivities(
                new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.example.com")), 0);

        //noinspection Convert2streamapi
        for (ResolveInfo info : resolvedActivityList) {
            if (pm.resolveService(new Intent()
                    .setAction(ACTION_CUSTOM_TABS_CONNECTION)
                    .setPackage(info.activityInfo.packageName), 0) != null) {
                packagesSupportCustomTabs.add(info.activityInfo.packageName);
            }
        }

        return packagesSupportCustomTabs;
    }

    /**
     * Return the package name of the default browser on the device
     *
     * @param context   Context
     * @return  The package name of the default browser
     */
    private static String getDefaultBrowser(Context context) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://example.com"));
        PackageManager pm = context.getPackageManager();
        ResolveInfo resolveInfo = pm.resolveActivity(browserIntent, PackageManager.MATCH_DEFAULT_ONLY);

        if (resolveInfo == null) {
            return null;
        }

        return resolveInfo.activityInfo.packageName;
    }


    static class ServiceConnection extends CustomTabsServiceConnection {
        private WeakReference<CustomTabsDelegate> mDelegate;

        ServiceConnection(CustomTabsDelegate delegate) {
            mDelegate = new WeakReference<>(delegate);
        }

        @Override
        public void onCustomTabsServiceConnected(@NonNull ComponentName name, @NonNull CustomTabsClient client) {
            CustomTabsDelegate delegate = mDelegate.get();
            if (delegate != null) {
                delegate.onServiceConnected(client);
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            CustomTabsDelegate delegate  = mDelegate.get();
            if (delegate != null) {
                delegate.onServiceDisconnected();
            }
        }
    }
}
