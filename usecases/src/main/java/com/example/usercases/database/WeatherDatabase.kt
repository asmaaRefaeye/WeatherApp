package com.example.usercases.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters
import com.example.entities.packageInfo.City
import com.example.entities.packageInfo.FavoriteCityId

@Database(
      entities = [City::class ,FavoriteCityId::class],
      version = 1,
      exportSchema = false
 )

@TypeConverters(CoordinatesTypeConverter::class)


abstract class WeatherDatabase : RoomDatabase (){
     abstract val citiesDAO : CitiesDAO
     abstract val favaroitiesDAO :FavaroitiesDAO

}