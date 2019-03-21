package com.example.usercases

import android.arch.lifecycle.ComputableLiveData
import android.arch.lifecycle.MutableLiveData

fun numberIncrementer(liveData: MutableLiveData<Int>,incementBy:Int=1){

    val oldvalue = liveData.value ?:0
    liveData.postValue(oldvalue+incementBy)
}