package com.waether.app.Features.forecast

import android.arch.lifecycle.LifecycleOwner
import com.example.entities.packageInfo.City


class ForecastPresenterImplementer(private val view: ForecastView) : ForecastPresenter {

    var city : City? = null

    override fun initializeCity(city: City) {
        this.city = city
    }

    /*override fun onCreate(owner: LifecycleOwner) {
        ShowCityForecastUseCase().invoke(city?.id!!)
    }*/

    override fun addCityToFavoritesClicked() {
    }

    override fun removeCityFromFavorites() {
    }

    override fun onDestroy(owner: LifecycleOwner) {
        city = null
    }
}