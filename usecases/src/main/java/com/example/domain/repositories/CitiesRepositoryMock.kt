package com.example.domain.repositories

import com.example.entities.packageInfo.City
import com.example.entities.packageInfo.FavoriteCityId

open class CitiesRepositoryMock : citiesReposotiry {
    override fun SearchCityByNames(name: String): List<City> {
        return listOf()
    }

    override fun retrieveFavoitCities(): List<FavoriteCityId> {
        return listOf()
    }

    override fun retrieveCitiesByIDs(favoritcityIds: List<Long>): List<City> {
        return listOf()
    }

    override fun addFavoiritCityId(favoiritcityId: FavoriteCityId) {

    }

    override fun removeFavoiritCityId(favoiritcityId: FavoriteCityId) {
      }



}