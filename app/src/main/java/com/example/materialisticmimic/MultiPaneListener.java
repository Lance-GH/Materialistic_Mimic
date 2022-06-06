package com.example.materialisticmimic;

import androidx.annotation.Nullable;

import com.example.materialisticmimic.data.WebItem;

public interface MultiPaneListener {

    /**
     * Fired when an item has been selected in list view when multi-pane is active
     * @param item      selected item or null if selection is clear
     */
    void onItemSelected(@Nullable WebItem item);

    /**
     * Gets item that has been opened via {@link #onItemSelected(WebItem)}
     * @return  opened item or null
     */
    WebItem getSelectedItem();

    /**
     * Checks if multi pane configuration is active
     * @return  true if multi pane, false if single pane
     */
    boolean isMultiPane();
}
