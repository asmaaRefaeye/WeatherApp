package com.waether.app.Features.home

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.example.usercases.Ticker
import com.example.usercases.numberIncrementer


 const val DEFUALT_VALUE = 0
private const val INCREMENT_BY_VALUE = 1



class RandamizeViewModel  : ViewModel() {

    var randomValue = MutableLiveData<Int>()
 //   private val ticker = initializeTicker()


    init {
        randomValue.value = DEFUALT_VALUE
      //  ticker.start()

    }

    fun increamentNumber (){
        numberIncrementer(randomValue)

    }

   /* private fun initializeTicker(): Ticker {

       return Ticker{
           val oldValues = randomValue.value ?: DEFUALT_VALUE
           randomValue.postValue(oldValues + INCREMENT_BY_VALUE)
    }
    }
*/

   /* override fun onCleared (){
        super.onCleared()
       // ticker.onFinish()
    }
*/



}