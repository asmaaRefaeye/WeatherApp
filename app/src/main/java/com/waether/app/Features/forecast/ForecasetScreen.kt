package com.waether.app.Features.forecast


import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.entities.packageInfo.City
import com.waether.app.Core.ContentViewId
import com.waether.app.Features.home.EXTRA_CITY
import com.waether.app.R
import kotlinx.android.synthetic.main.activity_main.*


@ContentViewId(R.layout.activity_main)
class ForecastActivity : AppCompatActivity(),ForcastView {

    private val presenter : Forecastpresenter by lazy {ForecastPresenterImplementer(this)   }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val city = intent.getSerializableExtra(EXTRA_CITY) as City
        presenter.intializeView(city)

        add_favouirities_button.setOnClickListener {
           if (it.isSelected) {
               presenter.removecityfromfavorites()
           }else {
               presenter.addcitytofavourit()
           }

        }

    }


    override fun startloading() {
     // progress.visiblity = VISIBLE
    }

    override fun stoploading() {
       // progress.visiblity = GONE
    }

    override fun drawforcast(forcast: List<ForcastView>) {
      //  recyclerview.adapter = ForecastAdapter(forcasts)
    }

    override fun drawCityTitle(cityTitle: String) {

    }

    override fun drawAsFavoritesCity() {
         add_favouirities_button.isSelected = true
    }

    override fun drawAsNotFavoritesCity() {
        add_favouirities_button.isSelected = false
    }
}