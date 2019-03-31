package com.example.domain.usecase

import android.arch.lifecycle.MutableLiveData
import com.example.domain.repositories.citiesReositries
import com.example.domain.repositories.citiesReposotiry
import com.example.entities.packageInfo.City

// usecase 3 : retrieve cities by Ids
// if is retrieving, then do not trigger action
// if all is Ok, trigger action


class SearchCitiesByIdsUseCase(
    private val result: MutableLiveData<List<City>>,
    private val searching: MutableLiveData<Boolean>,
    private val repository: citiesReposotiry = citiesReositries
) {

    operator fun invoke(citiesIds: List<Long>) {
        citiesIds.takeUnless { searching.value ?: false }
            ?.also { searching.postValue(true) }
            ?.let { repository.retrieveCitiesByIDs(it) }
            ?.also { result.postValue(it) }
            ?.also { searching.postValue(false) }
    }


}