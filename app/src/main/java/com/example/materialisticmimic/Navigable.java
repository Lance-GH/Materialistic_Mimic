package com.example.materialisticmimic;

public interface Navigable {

    int DIRECTION_UP = 0;
    int DIRECTION_DOWN = 1;
    int DIRECTION_LEFT = 2;
    int DIRECTION_RIGHT = 3;

    void onNavigate(int direction);
}
