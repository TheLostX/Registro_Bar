package com.lost.kotlinejercicioregistrobar

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.lost.kotlinejercicioregistrobar.databinding.ItemLayoutBinding

class CheckItemAdapter(var itemList: List<Items>) : RecyclerView.Adapter<CheckItemViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CheckItemViewHolder {

        val binding: ItemLayoutBinding = ItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return CheckItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CheckItemViewHolder, position: Int) {
        holder.bind(itemList[position])
    }

    override fun getItemCount(): Int {
        return itemList.size
    }
}