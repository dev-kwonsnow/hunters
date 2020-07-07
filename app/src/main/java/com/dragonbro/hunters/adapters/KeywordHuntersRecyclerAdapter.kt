package com.dragonbro.hunters.adapters

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dragonbro.hunters.R
import com.dragonbro.hunters.data.KeywordHunterData
import com.dragonbro.hunters.ui.HunterProfileActivity
import kotlinx.android.synthetic.main.keyword_hunter_item.view.*

class KeywordHuntersRecyclerAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var selectedId: Int = 0
    private var dataSet = mutableListOf<KeywordHunterData>()

    fun setData(dataList: MutableList<KeywordHunterData>) {
        dataSet = dataList
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.keyword_hunter_item, parent, false)
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

        fun bind(data: KeywordHunterData?) {
            data?.let {
                itemView.name.text = data.name
                itemView.special_part.text = data.specialPart
                Glide.with(itemView.context).load(data.thumbnail).into(itemView.thumbnail)
                itemView.description.text = data.description
                itemView.matching_percent_num.text = data.matchingPercentNum
                itemView.grade.text = data.grade
                itemView.consult_cnt.text = data.consultCnt

                for(keywordStr in data.keywordList) {
                    var newKeywordTextView = TextView(itemView.context)
                    itemView.keyword.addView(setKeywordData(keywordStr, newKeywordTextView))
                }

                itemView.keyword_item_view.setOnClickListener {
                    selectedId = data.id
                    val intent = Intent(itemView.context, HunterProfileActivity::class.java)
                    intent.putExtra("hunter_id", selectedId)
                    itemView.context.startActivity(intent)
                }
            }
        }

        private fun setKeywordData(keywordStr: String, textView: TextView): TextView {
            val layoutParams = LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
            layoutParams.setMargins(0, 0,10,0)
            textView.layoutParams = layoutParams
            textView.setPadding(15, 5, 15, 5)
            textView.includeFontPadding = false
            textView.gravity = 1
            textView.isSingleLine = true
            textView.setTypeface(
                Typeface.create("fonts/spoqahansansregular.ttf", Typeface.NORMAL)
            )
            textView.setTextColor(Color.parseColor("#ffffff"))
            textView.setBackgroundResource(R.drawable.keyword)
            textView.textSize = 10.0F
            textView.text = keywordStr
            return textView
        }
    }
}

