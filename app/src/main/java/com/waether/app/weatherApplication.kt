package com.waether.app

import android.app.Application
import com.example.usercases.Integration

class weatherApplication : Application (){

     override fun onCreate() {
         super.onCreate()
         Integration.integratewith(Application())
     }
 }


