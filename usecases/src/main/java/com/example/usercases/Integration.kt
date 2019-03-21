package com.example.usercases

import android.app.Application
import android.arch.lifecycle.MutableLiveData

internal  val applicationLoveData =MutableLiveData<Application>()
internal  fun  MutableLiveData<Application>.getNonNull():Application{
    return this.value!!
}


object Integration {

    fun integratewith(application: Application){
        applicationLoveData.value=application


    }

}