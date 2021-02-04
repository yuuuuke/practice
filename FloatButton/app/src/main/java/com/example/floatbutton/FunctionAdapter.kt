package com.example.floatbutton

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_function.view.*

/**
 * description:功能列表
 *
 * @author zwp
 * @since 2021/1/26
 */
class FunctionAdapter(private val mContext: Context) :
    RecyclerView.Adapter<FunctionAdapter.FunctionViewHolder>() {

    private val mData: ArrayList<FunctionBean> = ArrayList(10)

    /**
     * 在头部添加
     */
    fun addData(bean: FunctionBean) {
        mData.add(0, bean)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FunctionViewHolder {
        val view = LayoutInflater.from(mContext).inflate(R.layout.item_function, parent, false)
        return FunctionViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    override fun onBindViewHolder(holder: FunctionViewHolder, position: Int) {
        holder.bindView(mData[position])
    }

    class FunctionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindView(bean: FunctionBean) {
            itemView.function_name.text = bean.desc
            itemView.function_name.setOnClickListener {
                bean.onClick.invoke()
            }
        }
    }
}