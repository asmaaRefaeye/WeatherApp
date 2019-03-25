package com.example.domain.usecase

import android.arch.lifecycle.MutableLiveData
import com.example.domain.repositories.CitiesRepositoryMock
import com.example.domain.repositories.citiesReposotiry
import com.example.entities.packageInfo.City
import org.junit.Assert
import org.junit.Assert.*
import org.junit.Test


// usecase 3 : retrieve cities by Ids
// if is retrieving, then do not trigger action
// if all is Ok, trigger action


class RetrieveCitiesByIdUsecaseUnitTest {


    // if all is Ok, trigger action
    @Test
    fun `invoke with successful then trigger action `(){

        //Arrange
         val  ids: List<Long>
         val  retrieving: MutableLiveData<Boolean>
         val  result: MutableLiveData<List<City>>
         val  repository: CitiesRepositoryForRetrievingCitiesID


        //Act



        //Assets

    }


}



class CitiesRepositoryForRetrievingCitiesID : CitiesRepositoryMock() {
    val result = listOf(
        City(0L, "", "", null),
        City(0L, "", "", null)
    )

    override fun retrieveCitiesByIDs(favoritcityIds: List<Long>): List<City>{
        return result
    }

}

