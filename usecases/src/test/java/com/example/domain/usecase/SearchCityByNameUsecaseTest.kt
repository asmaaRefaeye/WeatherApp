package com.example.domain.usecase

import android.arch.core.executor.testing.InstantTaskExecutorRule
import android.arch.lifecycle.MutableLiveData
import com.example.domain.repositories.CitiesRepositoryMock
import com.example.domain.repositories.citiesReositries
import com.example.entities.packageInfo.City
import org.junit.Assert
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test


// usecase 1 : search city by name
// if is searching, then do not trigger action
// city name must not be null
// city name must not be blank
// if all is OK, trigger search


class SearchCityByNameUsecaseTest {

  @JvmField
    @Rule
    val instantExecutorRule = InstantTaskExecutorRule()

   //  if all is OK, trigger search
    @Test
    fun `invoke with successfull response then update result ` (){


        //Arrange
        val searching = MutableLiveData<Boolean>()
        val cityName = "any name"
        val result = MutableLiveData<List<City>>()
        val repository = CitiesRepositoryForSearchCityByName()
        val SearchCityByNameUsecase =
            SearchCityByNameUsecase(searching, result, repository)


        //Act
        SearchCityByNameUsecase.invoke(cityName)


        //Assets
        Assert.assertTrue(result.value!!.isNotEmpty())

    }


    // city name must not be null
    @Test
    fun `invoke with null cityName then donot update result `(){

        //Arrange
        val searching = MutableLiveData<Boolean>()
        val cityName = ""
        val result = MutableLiveData<List<City>>()
        val repository = CitiesRepositoryForSearchCityByName()
        val SearchCityByNameUsecase =
            SearchCityByNameUsecase(searching, result, repository)


        //Act
        SearchCityByNameUsecase.invoke(cityName)

        //Assets
        Assert.assertTrue(result == null)

    }

    // if is searching, then do not trigger action
    @Test
    fun `invoke with searching as true then update result `(){

        //Arrange
        val searching = MutableLiveData<Boolean>()
        val cityName = " any name"
        val result = MutableLiveData<List<City>>()
        val repository = CitiesRepositoryForSearchCityByName()
        val SearchCityByNameUsecase =
            SearchCityByNameUsecase(searching, result, repository)


        //Act
        SearchCityByNameUsecase.invoke(cityName)

        //Assets
        Assert.assertTrue(result == null)

    }

    // city name must not be blank
    @Test
    fun ` invoke with blank cityName then donot update result`(){

        //Arragne
        val searching = MutableLiveData<Boolean>()
        val cityName = ""
        val result = MutableLiveData<List<City>>()
        val repository = CitiesRepositoryForSearchCityByName()
        val SearchCityByNameUsecase =
            SearchCityByNameUsecase(searching, result, repository)


        //Act
        SearchCityByNameUsecase.invoke(cityName)

        //Assets
        Assert.assertTrue(result == null)
    }





}


class CitiesRepositoryForSearchCityByName :CitiesRepositoryMock() {
    val result = listOf(
        City(0L, "", "", null),
        City(0L, "", "", null)
    )

   override fun SearchCityByNames(name: String): List<City> {
        return result
    }

}





