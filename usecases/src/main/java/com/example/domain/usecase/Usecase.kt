package com.example.domain.usecase

import android.arch.lifecycle.MutableLiveData
import com.example.entities.packageInfo.City
import com.example.domain.repositories.citiesReositries
import com.example.domain.repositories.citiesReposotiry

fun numberIncrementer(liveData: MutableLiveData<Int>,incementBy:Int=1){

    val oldvalue = liveData.value ?:0
    liveData.postValue(oldvalue+incementBy)
}


// usecase 2 : retrieve favorite cities ids (longs)
// if is retrieving, then do not trigger action
// if favorites is empty, throw an exception
// if favorites not empty, convert them to ids (longs)


// usecase 3 : retrieve cities by Ids
// if is retrieving, then do not trigger action
// if all is Ok, trigger action


fun retrieveCitiesByIds(

    ids: List<Long>,
    retrieving: MutableLiveData<Boolean>,
    result: MutableLiveData<List<City>>,
    repository: citiesReposotiry = citiesReositries
) {

    ids.takeUnless { retrieving.value ?: false }
        ?.also { retrieving.postValue(true) }
        ?.let { repository.retrieveCitiesByIDs(it) }
        ?.also { result.postValue(it) }
        ?.also { retrieving.postValue(false) }
}






