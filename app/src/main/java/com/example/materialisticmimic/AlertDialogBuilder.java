package com.example.materialisticmimic;

import android.app.AlertDialog;
import android.app.Dialog;

public interface AlertDialogBuilder<T extends Dialog> {

    class Impl implements AlertDialogBuilder<AlertDialog> {
        private AlertDialog.Builder mBuilder;

        public Impl() {

        }
    }
}
