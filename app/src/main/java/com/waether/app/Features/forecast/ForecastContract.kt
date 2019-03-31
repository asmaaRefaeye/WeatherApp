package com.waether.app.Features.forecast

import android.arch.lifecycle.DefaultLifecycleObserver
import com.example.entities.packageInfo.City
import com.example.entities.packageInfo.Forecast

interface ForecastView {
    fun drawCityTitle(cityTitle: String)
    fun startLoading()
    fun stopLoading()
    fun drawForcastList(forcasts: List<Forecast>)
    fun drawAsFavoriteCity()
    fun drawAsNotFavoriteCity()
}
interface ForecastPresenter : DefaultLifecycleObserver {
    fun initializeCity(city: City)
    fun addCityToFavoritesClicked()
    fun removeCityFromFavorites()
}
