package com.example.materialisticmimic;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.loader.ResourcesProvider;
import android.widget.PopupMenu;

import com.example.materialisticmimic.widget.NewActivity;
import com.example.materialisticmimic.widget.StoryRecyclerViewAdapter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(
        injects = {
                AboutActivity.class,
                AskActivity.class,
                BestActivity.class,
                ComposeActivity.class,
                FavoriteActivity.class,
                FeedbackActivity.class,
                ItemActivity.class,
                JobsActivity.class,
                ListActivity.class,
                LoginActivity.class,
                NewActivity.class,
                OfflineWebActivity.class,
                PopularActivity.class,
                ReleaseNotesActivity.class,
                SearchActivity.class,
                SettingsActivity.class,
                ShowActivity.class,
                SubmitActivity.class,
                ThreadPreviewActivity.class,
                UserActivity.class,
                WidgetConfigActivity.class,
                FavoriteFragment.class,
                ItemFragment.class,
                ListFragment.class,
                WebFragment.class,
                FavoriteRecyclerViewAdapter.class,
                SinglePageItemRecyclerViewAdapter.class,
                StoryRecyclerViewAdapter.class,
                SubmissionRecyclerViewAdapter.class,
                MultiPageItemRecyclerViewAdapter.class,
                ThreadPreviewRecyclerViewAdapter.class

        },
        library = true,
        complete = false
)

class UiModule {
        @Provides
        public PopupMenu providePopupMenu() { return new PopupMenu.Impl(); }

        @Provides @Singleton
        public CustomTabsDelegate provideCustomTabsDelegate() { return new CustomTabsDelegate(); }

        @Provides @Singleton
        public KeyDelegate provideKeyDelegate() {return new KeyDelegate(); }

        @Provides @Singleton
        public ActionViewResolver provideActionViewResolver() { return new ActionViewResolver(); }

        @Provides
        public AlertDialogBuilder provideAlertDialogBuilder() { return new AlertDialogBuilder.Impl(); }

        @SuppressLint("Recycle")
        @Provides @Singleton
        public ResourcesProvider provideResourcesProvider(Context context) {
                return resId -> context.getResources().obtainTypedArray(resId);
        }
}
