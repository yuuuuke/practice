package com.example.floatbutton.function11

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.floatbutton.R

/**
 * description:
 *
 * @author zwp
 * @since 2021/9/16
 */
class TestAdapter(var data: ArrayList<TestBean>) :
    RecyclerView.Adapter<TestAdapter.MyViewHolder>() {

    fun setDatas(mData:ArrayList<TestBean>){
        data = mData
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_function, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bindView(data[position])
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int, payloads: MutableList<Any>) {
        super.onBindViewHolder(holder, position, payloads)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val age: TextView = itemView.findViewById(R.id.function_name)

        @SuppressLint("SetTextI18n")
        fun bindView(data: TestBean) {
            age.text = data.name + data.age
        }
    }
}