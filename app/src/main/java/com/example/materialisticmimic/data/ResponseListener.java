package com.example.materialisticmimic.data;

import androidx.annotation.Nullable;

/**
 * Callback interface for requests
 * @param <T> response type
 */
public interface ResponseListener<T> {

    /**
     * Fired when request is successful
     * @param response result
     */
    void onResponse(@Nullable T response);

    /**
     * Fired when request is failed
     * @param errorMessage error message or null
     */
    void onError(String errorMessage);
}
