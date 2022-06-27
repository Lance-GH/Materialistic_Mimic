package com.example.materialisticmimic;

import dagger.Module;

@Module(library = true, complete = false, includes = NetworkModule.class)
public class DataModule {
    public static final String MAIN_THREAD = "main";
    public static final String IO_THREAD = "io";
}
