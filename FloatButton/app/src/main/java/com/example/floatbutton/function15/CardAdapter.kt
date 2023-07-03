package com.example.floatbutton.function15

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.floatbutton.R
import kotlin.math.roundToInt

class CardAdapter : RecyclerView.Adapter<CardAdapter.VH>() {

    class VH(item: View) : ViewHolder(item) {

        public fun bindView() {

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_card, parent, false)
        return VH(view)
    }

    override fun getItemCount(): Int {
        return 5
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.bindView()
    }
}