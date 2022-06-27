package com.example.materialisticmimic;

import android.view.MenuItem;
import android.view.View;

class ActionViewResolver {

    /**
     * Returns the currently set action view for this menu item.
     *
     * @param menuItem the item to query
     * @return This item's action view
     */
    View getActionView(MenuItem menuItem) { return menuItem.getActionView(); }
}
