package com.lost.kotlinejercicioregistrobar

import androidx.lifecycle.LiveData
import androidx.room.*


@Dao
interface ItemsDao {

    @Query("SELECT * FROM items")
    fun getAll():LiveData<List<Items>>

    @Query("SELECT * FROM items")
    fun getAllItems(): List<Items>

    @Insert
    fun insertAll(vararg items: Items)

    @Update
    fun updateAll(vararg items: Items)

    @Delete
    fun deleteAll(value: List<Items>)
}