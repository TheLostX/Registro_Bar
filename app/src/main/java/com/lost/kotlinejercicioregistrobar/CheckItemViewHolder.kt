package com.lost.kotlinejercicioregistrobar

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.lost.kotlinejercicioregistrobar.databinding.ItemLayoutBinding


class CheckItemViewHolder(private val binding: ItemLayoutBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Items){

        with(binding){
            tvNombre.text = item.name
            tvCantidad.text = item.amount.toString()
            tvTotal3.text = item.price.toString()

        }
    }

}