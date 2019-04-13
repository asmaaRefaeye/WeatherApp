package com.example.domain.usecase

import android.arch.lifecycle.MutableLiveData
import com.example.domain.repositories.CitiesReposotiry
import com.example.domain.repositories.citiesReositries
import com.example.entities.packageInfo.City



    typealias citiesResult = MutableLiveData<List<City>>

   class SearchCityByNameUsecase  (
        val searching : MutableLiveData<Boolean>,
        val result: MutableLiveData<List<City>>,
        val  repository : CitiesReposotiry = citiesReositries )

{
       operator fun invoke  ( cityName: String?) {

         cityName
             ?.takeUnless { searching.value ?: false }
             ?.takeUnless { it.isBlank() }
             ?.also { searching.postValue(true) }
             ?.let { repository.SearchCityByNames(it) }
             ?.also { result.postValue(it) }
             ?.also { searching.postValue(false) }

       }

    }
