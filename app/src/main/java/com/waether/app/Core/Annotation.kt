package com.waether.app.Core

@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.CLASS)
annotation class ContentViewId(val layoutId: Int)