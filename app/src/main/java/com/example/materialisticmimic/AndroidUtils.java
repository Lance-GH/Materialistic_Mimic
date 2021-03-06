package com.example.materialisticmimic;

import androidx.annotation.Nullable;

public interface AndroidUtils {

    class TextUtils {

        public static boolean equals(CharSequence a, CharSequence b) {
            if (a == b) return true;
            int length;
            if (a != null && b != null && (length = a.length()) == b.length()) {
                if (a instanceof String && b instanceof  String) {
                    return a.equals(b);
                } else {
                    for (int i = 0; i < length; i++) {
                        if (a.charAt(i) != b.charAt(i)) return false;
                    }
                    return true;
                }
            }
            return false;
        }

        /**
         * Returns true if the string is null or 0-length.
         * @param str the string to be examined
         * @return true if str is null or zero length
         */
        public static boolean isEmpty(@Nullable CharSequence str) {
            return str == null || str.length() == 0;
        }
    }
}
