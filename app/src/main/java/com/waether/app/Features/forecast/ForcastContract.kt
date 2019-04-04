package com.waether.app.Features.forecast

import com.example.entities.packageInfo.City
import com.example.entities.packageInfo.Forecast


interface ForcastView {
    fun drawCityTitle(cityTitle : String)
    fun startloading()
    fun stoploading()
    fun drawforcast(forcast: List<ForcastView>)
    fun drawAsFavoritesCity()
    fun drawAsNotFavoritesCity()

}

interface  Forecastpresenter {

    fun intializeView(city : City)
    fun addcitytofavourit()
    fun removecityfromfavorites()

}