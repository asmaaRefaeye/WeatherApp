package com.waether.app.Features.home

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.waether.app.Core.ContentViewId
import com.waether.app.Features.forecast.ForecastActivity
import com.waether.app.R
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.fragment_home.*
import java.util.concurrent.TimeUnit
import java.io.Serializable

@ContentViewId(R.layout.fragment_home)
class HomeScreen : AppCompatActivity() {

    class HomeFragment : Fragment() {
        private val viewModel by lazy { ViewModelProviders.of(this).get(HomeViewModel::class.java) }
        private val disposables = CompositeDisposable()

        private val showButtonReceiver = object : BroadcastReceiver() {
            override fun onReceive(context: Context?, intent: Intent?) {
                viewModel.showCityForecast.onNext(intent!!.getSerializableExtra(EXTRA_CITY))
            }
        }

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)

            viewModel.searchProgress.observe(this, Observer {
                search_progress_bar.visibility = if (it!!) View.VISIBLE else View.GONE
            })

            // sending retrieving data using subjectpublish in RXJAva
            viewModel.showCityForecast
                .debounce(500, TimeUnit.MILLISECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { startForecastScreen(it) }
                .also { disposables.add(it) }

            search_button.setOnClickListener {
                viewModel.onSearchButtonClicked(search_edit_text.text?.toString())
            }


            results_recycler_view.layoutManager = LinearLayoutManager(this.activity)
            results_recycler_view.adapter = CitySearchResultsAdapter(this, viewModel.citiesResult)

            activity?.registerReceiver(showButtonReceiver, IntentFilter(ACTION_SHOW_CITY_BUTTON_CLICKED))
        }

        private fun startForecastScreen(citySerializable: Serializable) {
            Intent(context, ForecastActivity::class.java)
                .putExtra(EXTRA_CITY, citySerializable)
                .also { startActivity(it) }
        }

        override fun onDestroy() {
            activity?.unregisterReceiver(showButtonReceiver)
            disposables.dispose()
            super.onDestroy()
        }
    }

}