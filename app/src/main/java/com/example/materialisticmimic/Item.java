package com.example.materialisticmimic;

import com.example.materialisticmimic.data.WebItem;

public interface Item extends WebItem {


    void populate(Item info);

    String getRawType();

    String getRawUrl();

    long[] getKids();

    String getBy();

    long getTime();

    String getTitle();

    String getText();

    int getKidCount();

    int getLastKidCount();

    void setLastKidCount(int lastKidCount);

    boolean hasNewKids();

    Item[] getKidItems();

    int getLocalRevision();

    void setLocalRevision(int localRevision);

    int getDescendents();

    boolean isViewed();

    void setIsViewed();

    int getLevel();

    String getParent();

    Item getParentItem();

    boolean isDeleted();

    boolean isDead();

    int getScore();

    void incrementScore();

    boolean isVoted();

    boolean isPendingVoted();

    void clearPendingVoted();

    boolean isCollapsed();

    void setCollapsed();

    int getRank();

    boolean isContentExpanded();

    void setContentExpanded();

    void setNeighbour(int direction);

    CharSequence getDisplayedText();
}
