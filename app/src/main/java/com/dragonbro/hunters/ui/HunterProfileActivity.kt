package com.dragonbro.hunters.ui

import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.TypedValue
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.bumptech.glide.Glide
import com.dragonbro.hunters.R
import com.dragonbro.hunters.data.HunterInfo
import kotlinx.android.synthetic.main.activity_hunter_profile.*

class HunterProfileActivity : AppCompatActivity() {

    private val hunterInfo = HunterInfo(
        1,
        "최가현",
        "https://img1.daumcdn.net/thumb/R800x0/?scode=mtistory2&fname=https%3A%2F%2Ft1.daumcdn.net%2Fcfile%2Ftistory%2F99B5724C5C25EAD90D",
        "디자인전문",
        "안녕하세요. 디자인업계에서 20년동안 10개 이상의 스킬들을 다뤄왔으며 많은 사용자들을 합격시켰습니다.",
        arrayListOf("UX/UI", "브랜딩", "서비스", "디자인", "개발"),
        arrayListOf("UX/UI", "브랜딩"),
        20,
        "4.9",
        "1만",
        "83",
        "100+"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hunter_profile)

        val hunter_id = intent.extras!!.getString("email")

        hunter_profile_title.text = hunterInfo.name + "님 프로필"
        Glide.with(this).load(hunterInfo.thumbnail).into(thumbnail)
        profile_follow_cnt.text = hunterInfo.followCnt
        consult_request_cnt.text = hunterInfo.consultRequestCnt
        consult_complete_cnt.text = hunterInfo.consultCompleteCnt

        hunter_name.text = hunterInfo.name

        val keywordIterator = hunterInfo.keywordList.iterator()
        for((i, v) in keywordIterator.withIndex()) {
            main_keyword.addView(setMainKeywordData(v, TextView(this)))

            if(i < hunterInfo.keywordList.size - 1) {
                main_keyword.addView(setMainKeywordSeperater(View(this)))
            }
        }

        for(matchingKeywordStr in hunterInfo.matchingKeywordList) {
            matching_keyword.addView(setMatchingKeywordData(matchingKeywordStr, TextView(this)))
        }

        matching_progress_bar.progress = hunterInfo.matchingPercentNum
        matching_percent.text = hunterInfo.matchingPercentNum.toString() + "%"
        matching_keyword_title.text = hunterInfo.matchingKeywordList.size.toString() + "개의 키워드가 매칭 되었어요."

        profile_back.setOnClickListener {
            this.finish()
        }
    }

    private fun setMainKeywordSeperater(view: View): View {
        val width = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 3.0F, resources.displayMetrics).toInt()
        val height = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 3.0F, resources.displayMetrics).toInt()
        val marginTop = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 7.0F, resources.displayMetrics).toInt()
        val marginLeftRight = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 6.0F, resources.displayMetrics).toInt()

        val layoutParams = ConstraintLayout.LayoutParams(
            width,
            height
        )
        layoutParams.setMargins(marginLeftRight, marginTop, marginLeftRight,0)
        view.layoutParams = layoutParams
        view.setBackgroundResource(R.drawable.seperate_circle)
        return view
    }

    private fun setMainKeywordData(keywordStr: String, textView: TextView): TextView {
        val layoutParams = ConstraintLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        textView.layoutParams = layoutParams
        textView.includeFontPadding = false
        textView.gravity = 1
        textView.isSingleLine = true
        textView.setTypeface(
            Typeface.create("fonts/spoqahansansregular.ttf", Typeface.NORMAL)
        )
        textView.setTextColor(Color.parseColor("#888888"))
        textView.textSize = 13.0F
        textView.text = keywordStr
        return textView
    }

    private fun setMatchingKeywordData(keywordStr: String, textView: TextView): TextView {
        val marginTop = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 5.0F, resources.displayMetrics).toInt()
        val marginLeftRight = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 6.0F, resources.displayMetrics).toInt()
        val paddingTopBottom = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 3.0F, resources.displayMetrics).toInt()
        val paddingLeftRight = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 7.0F, resources.displayMetrics).toInt()

        val layoutParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        layoutParams.setMargins(0, 0, marginLeftRight,marginTop)
        textView.layoutParams = layoutParams
        textView.setPadding(marginLeftRight, paddingTopBottom, paddingLeftRight, paddingTopBottom)
        textView.includeFontPadding = false
        textView.gravity = 1
        textView.isSingleLine = true
        textView.setTypeface(
            Typeface.create("fonts/spoqahansansregular.ttf", Typeface.NORMAL)
        )
        textView.setTextColor(Color.parseColor("#ffffff"))
        textView.setBackgroundResource(R.drawable.keyword)
        textView.textSize = 11.0F
        textView.text = keywordStr
        return textView
    }

}