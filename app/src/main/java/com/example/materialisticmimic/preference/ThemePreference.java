package com.example.materialisticmimic.preference;

import android.content.Context;
import android.preference.Preference;
import android.util.AttributeSet;

import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.collection.ArrayMap;

import com.example.materialisticmimic.R;
import com.example.materialisticmimic.annotation.Synthetic;

public class ThemePreference extends Preference {

    private static final String LIGHT = "light";
    private static final String DARK = "dark";
    private static final String BLACK = "black";
    private static final String SEPIA = "sepia";
    private static final String GREEN = "green";
    private static final String SOLARIZED = "solarized";
    private static final String SOLARIZED_DARK = "solarized_dark";

    private static final ArrayMap<Integer, String> BUTTONS = new ArrayMap<>();
    private static final ArrayMap<Integer, String> VALUES = new ArrayMap<>();

    static {
        BUTTONS.put(R.id.theme_light, LIGHT);
        BUTTONS.put(R.id.theme_dark, DARK);
        BUTTONS.put(R.id.theme_black, BLACK);
        BUTTONS.put(R.id.theme_sepia, SEPIA);
        BUTTONS.put(R.id.theme_green, GREEN);
        BUTTONS.put(R.id.theme_solarized, SOLARIZED);
        BUTTONS.put(R.id.theme_solarized_dark, SOLARIZED_DARK);

        VALUES.put(LIGHT, new DayNightSpec(R.string.theme_light));
        VALUES.put(DARK, new DayNightSpec(R.string.theme_dark));
        VALUES.put(BLACK, new DayNightSpec(R.string.theme_black, R.style.Black));
        VALUES.put(SEPIA, new DayNightSpec(R.string.theme_sepia, R.style.Sepia));
        VALUES.put(GREEN, new DayNightSpec(R.string.theme_green, R.style.Green));
        VALUES.put(SOLARIZED, new DayNightSpec(R.string.theme_solarized, R.style.Solarized));
        VALUES.put(SOLARIZED_DARK, new DayNightSpec(R.string.theme_solarized_dark,
                R.style.Solarized_Dark));
    }

    public ThemePreference(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public ThemePreference(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public static class ThemeSpec {
        final @StringRes int summary;
        public final @StyleRes int theme;
        public final @StyleRes int themeOverrides;
        ThemeSpec translucent;

        @Synthetic
        ThemeSpec(@StringRes int summary, @StyleRes int theme, @StyleRes int themeOverrides) {
            this.summary = summary;
            this.theme = theme;
            this.themeOverrides = themeOverrides;
        }

        ThemeSpec getTranslucent() { return this; }
    }

    public static class DayNightSpec extends ThemeSpec {

        DayNightSpec(@StringRes int summary) {
            this(summary, -1);
        }

        DayNightSpec(@StringRes int summary, @StyleRes int themeOverrides) {
            super(summary, R.style.AppTheme_DayNight, themeOverrides);
        }

        @Override
        ThemeSpec getTranslucent() {
            if (translucent == null) {
                translucent = new ThemeSpec(summary, R.style.AppTheme_Translucent, themeOverrides);
            }
            return translucent;
        }
    }
}
