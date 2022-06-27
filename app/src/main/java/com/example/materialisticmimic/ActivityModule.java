package com.example.materialisticmimic;


import android.accounts.AccountManager;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(
        injects = {
                ItemSyncService.class,
                WidgetService.class,
                ItemSyncJobService.class
        },
        library = true,
        includes = DataModule.class
)

public class ActivityModule {
        public static final String ALGOLIA = "algolia";
        public static final String POPULAR = "popular";
        public static final String HN = "hn";

        private final Context mContext;

        public ActivityModule(Context context) {
                mContext = context;
        }

        @Provides
        @Singleton
        public Context provideContext() {
                return mContext;
        }

        @Provides @Singleton
        public AccountManager provideAccountManager(Context context) {
                return AccountManager.get(context);
        }
}
