package com.example.domain.usecase

import android.arch.core.executor.testing.InstantTaskExecutorRule
import android.arch.lifecycle.MutableLiveData
import com.example.domain.repositories.CitiesRepositoryMock
import com.example.entities.packageInfo.City
import org.junit.Assert
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test


// usecase 3 : retrieve cities by Ids
// if is retrieving, then do not trigger action
// if all is Ok, trigger action

class SearchCitiesByIdsUseCaseTest {

    @JvmField
    @Rule
    val instantExecutorRule = InstantTaskExecutorRule()



    // if all is Ok, trigger action
    @Test
    fun `invoke with sucessful response then update resultLivedata value  `()
    {

        //Arrange
        val citiesIds = listOf(1L,2L,3L)
        val result = MutableLiveData<List<City>>()
        val repository = CitiesRepositoryForSearchCitiesByIds()
        val searching = MutableLiveData<Boolean>()
        val SearchCitiesByIdsUseCase = SearchCitiesByIdsUseCase(result ,searching,repository)

        //Act
        SearchCitiesByIdsUseCase(citiesIds)

        //Assert
         Assert.assertTrue(result.value!!.isNotEmpty())

    }


    // if is already searching, then do not trigger action
    @Test
    fun `invoke while searching then donot update livedata` (){


        //Arrange
        val citiesIds = listOf(1L,2L,3L)
        val result = MutableLiveData<List<City>>()
        val repository = CitiesRepositoryForSearchCitiesByIds()
        val searching = MutableLiveData<Boolean>()
        val SearchCitiesByIdsUseCase = SearchCitiesByIdsUseCase(result ,searching,repository)

        //Act
         searching.value =true
         SearchCitiesByIdsUseCase(citiesIds)

        //Assert
        Assert.assertTrue(result.value==null)

    }

}


class CitiesRepositoryForSearchCitiesByIds : CitiesRepositoryMock() {
    val result = listOf(
        City(0L, "", "", null),
        City(0L, "", "", null)
    )

    override fun retrieveCitiesByIDs(citiesids: List<Long>): List<City> {
        return result
    }

}
