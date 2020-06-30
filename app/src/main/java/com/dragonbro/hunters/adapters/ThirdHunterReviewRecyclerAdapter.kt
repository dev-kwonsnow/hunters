package com.dragonbro.hunters.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dragonbro.hunters.R
import kotlinx.android.synthetic.main.card_review_item.view.*

class ThirdHunterReviewRecyclerAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var dataSet = mutableListOf<String>()

    fun setData(dataList: MutableList<String>) {
        dataSet = dataList
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_review_item, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as? ItemViewHolder)?.let {
            val data = dataSet.getOrNull(position)
            it.bind(data)
        }
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

    private inner class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bind(data: String?) {
            data?.let {
                itemView.review_content.text = data
            }
        }
    }

}

