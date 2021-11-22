package com.lost.kotlinejercicioregistrobar

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = [Items::class], version = 1)
abstract class ConsumoDataBase : RoomDatabase(){
    abstract fun itemsDao(): ItemsDao

}