package com.dragonbro.hunters.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dragonbro.hunters.R
import com.dragonbro.hunters.data.SecondHunterData
import com.dragonbro.hunters.ui.HunterProfileActivity
import kotlinx.android.synthetic.main.second_hunter_item.view.*

class SecondHuntersRecyclerAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var selectedId: Int = 0
    private var dataSet = mutableListOf<SecondHunterData>()

    fun setData(dataList: MutableList<SecondHunterData>) {
        dataSet = dataList
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.second_hunter_item, parent, false)
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

        fun bind(data: SecondHunterData?) {
            data?.let {
                itemView.name.text = data.name
                itemView.special_part.text = data.specialPart
                Glide.with(itemView.context).load(data.thumbnail).into(itemView.thumbnail)
                itemView.description.text = data.description
                itemView.grade.text = data.grade
                itemView.like_cnt.text = data.likeCnt
                itemView.follower_cnt.text = data.followerCnt

                itemView.keyword_item_view.setOnClickListener {
                    selectedId = data.id
                    val intent = Intent(itemView.context, HunterProfileActivity::class.java)
                    intent.putExtra("hunter_id", selectedId)
                    itemView.context.startActivity(intent)
                }
            }
        }
    }
}

