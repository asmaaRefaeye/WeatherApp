package com.waether.app

import android.app.Application
import com.example.domain.Domain
import com.waether.app.Core.activitiesLifeCycleCallBacks


class WeatherApplication : Application (){

     override fun onCreate() {
         super.onCreate()
         registerActivityLifecycleCallbacks(activitiesLifeCycleCallBacks)
         Domain.integrateWith(this)
     }
 }


