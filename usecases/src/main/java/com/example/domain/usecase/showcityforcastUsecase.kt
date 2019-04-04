package com.example.domain.usecase

import com.example.domain.forecastsApis
import com.example.domain.repositories.ForecastsRepository
import com.example.domain.repositories.forecastsRepository
import com.example.entities.packageInfo.FavoriteCityId

class showcityforcastUsecase (private val reposotry :
                              ForecastsRepository = forecastsRepository) {

    operator fun invoke(cityId :Long) {
        reposotry.requestFiveDaysForecast(cityId.toString())
    }
}