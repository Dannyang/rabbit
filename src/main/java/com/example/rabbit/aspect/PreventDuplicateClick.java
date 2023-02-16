package com.example.rabbit.aspect;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface PreventDuplicateClick {
    /**
     * 防重复操作过期时间（借助redis实现限时控制）
     */
    long expireSeconds() default 10;
}
