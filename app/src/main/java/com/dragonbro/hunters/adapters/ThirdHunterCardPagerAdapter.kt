package com.dragonbro.hunters.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager.widget.PagerAdapter
import com.bumptech.glide.Glide
import com.dragonbro.hunters.R
import com.dragonbro.hunters.data.ThirdHunterData
import com.dragonbro.hunters.util.DividerItemDecoration
import kotlinx.android.synthetic.main.hunter_card_item.view.*


class ThirdHunterCardPagerAdapter(val context: Context, val mDataList: MutableList<ThirdHunterData>): PagerAdapter() {

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = inflater.inflate(R.layout.hunter_card_item, container, false)
        view.name.text = mDataList[position].name
        Glide.with(context).load(mDataList[position].thumbnail).into(view.thumbnail)
        view.special_part.text = mDataList[position].specialPart
        view.grade.text = mDataList[position].grade
        view.consult_cnt.text = mDataList[position].consultCnt

        val thirdListAdapter: ThirdHunterReviewRecyclerAdapter? = ThirdHunterReviewRecyclerAdapter()
        thirdListAdapter?.setData(mDataList[position].reviewList)

        val keywordRecyclerView = view.third_review_lists
        val keywordDividerItemDecoration = DividerItemDecoration(context, LinearLayoutManager.VERTICAL, false)
        keywordDividerItemDecoration.setDrawable(ContextCompat.getDrawable(context, R.drawable.seperate_line)!!)
        keywordRecyclerView.addItemDecoration(keywordDividerItemDecoration)
        keywordRecyclerView.layoutManager = LinearLayoutManager(context)
        keywordRecyclerView.adapter = thirdListAdapter

        container.addView(view)
        return view
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun getCount(): Int {
        return mDataList.size
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

}

