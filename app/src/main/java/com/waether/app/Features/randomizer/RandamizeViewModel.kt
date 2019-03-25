package com.waether.app.Features.randomizer

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.example.domain.usecase.numberIncrementer


const val DEFAULT_VALUE = 0

class RandomizerViewModel(
    val useCase : (MutableLiveData<Int>) -> Unit = { numberLiveData ->
        numberIncrementer(
            numberLiveData
        )
    }
) : ViewModel() {

    val numberLiveData = MutableLiveData<Int>()

    init {
        numberLiveData.value = DEFAULT_VALUE
    }

    fun incrementNumber(){
        useCase(numberLiveData)
    }

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



