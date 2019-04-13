package com.waether.app.Features.home

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.example.domain.Engine.toMutableLiveData
import com.example.domain.usecase.SearchCityByNameUsecase
import com.example.entities.packageInfo.City
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.PublishSubject
import java.io.Serializable

class HomeViewModel(
    val showCityForecast: PublishSubject<Serializable> = PublishSubject.create(),
    val searchProgress: MutableLiveData<Boolean> = false.toMutableLiveData(),
    val citiesResult: MutableLiveData<List<City>> = ArrayList<City>().toMutableLiveData(),
    private val disposables: CompositeDisposable = CompositeDisposable(),
    private val searchCityByName: SearchCityByNameUsecase = SearchCityByNameUsecase(
        searchProgress,
        citiesResult
    )
) : ViewModel() {

    fun getProgressLiveData() : LiveData<Boolean> = searchProgress

    fun onSearchButtonClicked(cityName: String?) {
       Observable.fromCallable { searchCityByName(cityName) }
           .subscribeOn(Schedulers.io())
           .observeOn(AndroidSchedulers.mainThread())
           .subscribe()
           .also { disposables.add(it) }

    }

    override fun onCleared() {
        super.onCleared()
        showCityForecast.onComplete()
        disposables.dispose()
    }
}