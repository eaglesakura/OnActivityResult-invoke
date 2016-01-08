package com.eaglesakura.android.oari;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * OnAfterViewsのハンドリングを行う
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.CLASS)
public @interface OnActivityResult {
    int value();
}
