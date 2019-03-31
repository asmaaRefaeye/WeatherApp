package com.example.domain.repositories

import com.example.domain.ForecastsApis
import com.example.domain.forecastsApis
import com.example.entities.packageInfo.ForecastsResponse
import io.reactivex.Single

val forecastsRepository: ForecastsRepository by lazy { ForecastRepositoryImplementer() }

interface ForecastsRepository {

    fun requestFiveDaysForecast(cityId: String): Single<ForecastsResponse>
}


class ForecastRepositoryImplementer(
    private val server: ForecastsApis = forecastsApis
) : ForecastsRepository {

    override fun requestFiveDaysForecast(cityId: String) = server.requestFiveDaysForecast(cityId)

}