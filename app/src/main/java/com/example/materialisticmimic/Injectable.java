package com.example.materialisticmimic;

import dagger.ObjectGraph;
/**
 * Injects for context that can be injected with dependencies
 */
public interface Injectable {

    void inject(Object object);

    ObjectGraph getApplicationGraph();
}
