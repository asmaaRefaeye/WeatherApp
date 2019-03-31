package com.waether.app.Core

import android.app.Activity
import android.app.Application
import android.os.Bundle

val activitiesLifeCycleCallBacks by lazy { ActivitiesLifeCycleCallBacks () }

class ActivitiesLifeCycleCallBacks : Application.ActivityLifecycleCallbacks {
    override fun onActivityPaused(activity: Activity?) {

    }

    override fun onActivityResumed(activity: Activity?) {
    }

    override fun onActivityStarted(activity: Activity?) {
    }

    override fun onActivityDestroyed(activity: Activity?) {
    }

    override fun onActivitySaveInstanceState(activity: Activity?, outState: Bundle?) {
    }

    override fun onActivityStopped(activity: Activity?) {
    }

    override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {


      /*  val LayoutId = activity.javaClass
            .getAnnotation(ContentViewId::class.java)
            .layoutId
        activity.setContentView(LayoutId)
*/
    }
}