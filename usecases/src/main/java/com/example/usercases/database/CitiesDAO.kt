package com.example.usercases.database

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Query
import com.example.entities.packageInfo.City

@Dao
interface CitiesDAO {

@Query("select * from City where City.name like '%' || :name || '%'")
    fun queryCitiesByName(name:String):List<City>

    @Query ("select * from City where City.id in (:ids)")
    fun queryCitiesById(ids:List<Long>):List<City>

}