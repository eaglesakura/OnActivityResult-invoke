package com.eaglesakura.android.oari;

import android.support.annotation.Keep;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * OnAfterViewsのハンドリングを行う
 */
@Keep
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface OnActivityResult {
    int value();
}
