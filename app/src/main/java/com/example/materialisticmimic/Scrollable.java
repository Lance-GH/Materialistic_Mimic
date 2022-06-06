package com.example.materialisticmimic;

/**
 * Interface for things that can be scrolled vertically
 */
public interface Scrollable {
    /**
     * Scrolls this instance to top, i.e. until no more content above
     */
    void scrollToTop();

    /**
     * Scrolls to reveal more content below current content
     * @return  true if successful, false if unable to scroll
     */
    boolean scrollToNext();

    /**
     * Scrolls to reveal more content above current content
     * @return  true if successful, false if unable to scroll
     */
    boolean scrollToPrevious();
}
