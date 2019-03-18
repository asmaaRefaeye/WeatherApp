package com.waether.app.Features.home

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.example.usercases.Ticker

private const val DEFUALT_VALUE = 0
private const val INCREMENT_BY_VALUE = 1



class RandamizeViewModel  : ViewModel() {

    var randomValue = MutableLiveData<Int>()
    private val ticker = initializeTicker()


    init {
        randomValue.value = 1
        ticker.start()

    }


    private fun initializeTicker(): Ticker {

       return Ticker{
           val oldValues = randomValue.value ?: DEFUALT_VALUE
           randomValue.postValue(oldValues + INCREMENT_BY_VALUE)
    }
    }


    override fun onCleared (){
        super.onCleared()
        ticker.onFinish()
    }




}