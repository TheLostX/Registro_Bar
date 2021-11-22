package com.lost.kotlinejercicioregistrobar

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class Items(
    @PrimaryKey (autoGenerate = true) val uid: Int,
    val name: String,
    val price:Int,
    val amount:Int
) {
}