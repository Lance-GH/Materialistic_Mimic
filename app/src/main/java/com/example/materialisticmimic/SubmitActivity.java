package com.example.materialisticmimic;

import com.example.materialisticmimic.accounts.UserServices;

import javax.inject.Inject;

public class SubmitActivity extends InjectableActivity {

    private static final String HN_GUIDELINES_URL = "https://news.ycombinator.com/newsguidelines.html";
    private static final String STATE_SUBJECT = "state:subject";
    private static final String STATE_TEXT = "state:next";
    // matching title url without any trailing text
    private static final String REGEX_FUZZY_URL = "(.*)((http|https)://[^\\s]*)$";
    @Inject
    UserServices mUserServices;
}
