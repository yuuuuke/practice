package com.example.floatbutton.function7

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.floatbutton.R
import kotlinx.android.synthetic.main.item_group.view.*

/**
 * description:适配器
 *
 * @author zwp
 * @since 2021/2/22
 */

class GroupAdapter(val list:ArrayList<String>) : RecyclerView.Adapter<GroupAdapter.GroupViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GroupViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_group,parent,false)
        return GroupViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: GroupViewHolder, position: Int) {
        holder.text.text = list[position]
    }


    inner class GroupViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val text = itemView.item_name
    }
}