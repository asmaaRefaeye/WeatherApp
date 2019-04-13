package com.example.domain.repositories

import com.example.entities.packageInfo.City
import com.example.entities.packageInfo.FavoriteCityId
import com.example.domain.database.WeatherDatabase
import com.example.domain.database.weatherdatabase


val citiesReositries :CitiesReposotiry by lazy { CitiesRepositriesImplementer()  }

interface CitiesReposotiry {
    fun SearchCityByNames (name:String) : List<City>

    fun retrieveFavoitCities ():List<FavoriteCityId>

    fun retrieveCitiesByIDs(favoritcityIds:List<Long>):List<City>

    fun addFavoiritCityId(favoiritcityId:FavoriteCityId) :Unit

    fun removeFavoiritCityId(favoiritcityId:FavoriteCityId) : Unit
}

class CitiesRepositriesImplementer(private val dataBase:WeatherDatabase = weatherdatabase )  :CitiesReposotiry{


   override  fun SearchCityByNames (name:String) : List<City> =  dataBase.citiesDAO.queryCitiesByName(name)

    override  fun retrieveFavoitCities ():List<FavoriteCityId> =dataBase.favaroitiesDAO.queryAll()

    override fun retrieveCitiesByIDs(favoritcityIds:List<Long>):List<City> = dataBase.citiesDAO.queryCitiesById(favoritcityIds )

    override fun addFavoiritCityId(favoiritcityId:FavoriteCityId) = dataBase.favaroitiesDAO.insert(favoiritcityId)

    override fun removeFavoiritCityId(favoiritcityId:FavoriteCityId) = dataBase.favaroitiesDAO.delete(favoiritcityId)
}


