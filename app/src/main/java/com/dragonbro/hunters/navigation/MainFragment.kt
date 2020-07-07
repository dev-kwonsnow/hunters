package com.dragonbro.hunters.navigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager.widget.ViewPager
import com.dragonbro.hunters.R
import com.dragonbro.hunters.adapters.KeywordHuntersRecyclerAdapter
import com.dragonbro.hunters.adapters.SecondHuntersRecyclerAdapter
import com.dragonbro.hunters.adapters.ThirdHunterCardPagerAdapter
import com.dragonbro.hunters.data.KeywordHunterData
import com.dragonbro.hunters.data.SecondHunterData
import com.dragonbro.hunters.data.ThirdHunterData
import com.dragonbro.hunters.util.DividerItemDecoration
import kotlinx.android.synthetic.main.fragment_main.view.*

class MainFragment : Fragment() {
    private val keywordListAdapter: KeywordHuntersRecyclerAdapter? = KeywordHuntersRecyclerAdapter()
    private val secondListAdapter: SecondHuntersRecyclerAdapter? = SecondHuntersRecyclerAdapter()
    private val keywordHunterDataList: MutableList<KeywordHunterData> = arrayListOf(
        KeywordHunterData(
            1,
            "최가현",
            "https://img1.daumcdn.net/thumb/R800x0/?scode=mtistory2&fname=https%3A%2F%2Ft1.daumcdn.net%2Fcfile%2Ftistory%2F99B5724C5C25EAD90D",
            "디자인전문",
            "안녕하세요. 디자인업계에서 20년동안 10개 이상의 스킬들을 다뤄왔으며 많은 사용자들을 합격시켰습니다.",
            arrayListOf("UX/UI", "브랜딩", "서비스"),
            "80%",
            "4.9",
            "100+"),
        KeywordHunterData(
            2,
            "안승호",
            "https://mblogthumb-phinf.pstatic.net/MjAxODA3MTZfMTg0/MDAxNTMxNzEyMjMwMzkw.GHN2KKpH7gs5ETOWnq9B5dQLur8RBBwD5ZBhnHgp5t8g.VVhvz2Zsnv4QNg9j58-Q8fdUjDDhuq5n5eGtY_Lr2PUg.JPEG.junsiks7/%EB%AA%A9%EB%8F%99%EC%97%90%EC%84%9C_%EC%A6%9D%EB%AA%85%EC%82%AC%EC%A7%84_%EC%9D%B4%EB%A0%A5%EC%84%9C_%EC%82%AC%EC%A7%84_%EC%9E%98%EC%B0%8D%EB%8A%94%EA%B3%B3_%EC%82%AC%EC%A7%84%EA%B4%80_%EC%A1%B0%EC%9D%B4%EB%A0%88%EC%BD%94%EB%93%9C.jpg?type=w2",
            "개발전문",
            "테스트",
            arrayListOf("UX/UI"),
            "75%",
            "4.6",
            "91")
    )
    private val secondHunterDataList: MutableList<SecondHunterData> = arrayListOf(
        SecondHunterData(
            1,
            "백성준",
            "https://dispatch.cdnser.be/wp-content/uploads/2017/02/be247503d597fc4b0c5c814ffd68a534.jpg",
            "디자인전문",
            "안녕하세요. 디자인 에에에에에에에에에에에에에에케케케케케케케케데데데데데데레레레레레레헤헤헤헤헤헤헤메메메메메",
            "4.9",
            "2k",
            "2000"),
        SecondHunterData(
            2,
            "김나희",
            "https://file3.instiz.net/data/file3/2020/02/18/a/f/1/af1f6844007ce00cf66ef3c71d2c6189.jpg",
            "개발전문",
            "테스트",
            "4.6",
            "301",
            "91"),
        SecondHunterData(
            3,
            "김승수",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcQt4ej1JKXJTWrliQP0eHcKEDiSy5euaFJbZw&usqp=CAU",
            "마케팅전문",
            "테헤테헤테헤테헤",
            "4.3",
            "102",
            "89")
    )

    private val thirdHunterCardDataList: MutableList<ThirdHunterData> = arrayListOf(
        ThirdHunterData(
            1,
            "권성수",
            "https://i.pinimg.com/originals/dd/11/09/dd11093f64f04935f1eb83f485bfeb7e.jpg",
            "개발전문",
            "4.8",
            "10",
            "1283",
            mutableListOf("채용완료 시 까지 친절하게 상담 해주셨어 좋은 조건으로 이직하게 되었어요!","최고에요!")),
        ThirdHunterData(
            2,
            "아이린",
            "https://file3.instiz.net/data/file3/2020/02/18/a/f/1/af1f6844007ce00cf66ef3c71d2c6189.jpg",
            "디자인전문",
            "4.9",
            "20",
            "2000",
            mutableListOf("채용완료 시 까지 친절하게 상담 해주셨어 좋은 조건으로 이직하게 되었어요!","좋아용!")),
        ThirdHunterData(
            3,
            "이진형",
            "https://dispatch.cdnser.be/wp-content/uploads/2017/02/be247503d597fc4b0c5c814ffd68a534.jpg",
            "마케팅전문",
            "4.6",
            "9",
            "332",
            mutableListOf("123445666","텟틋트트트트트트트트트트트트트"))
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = LayoutInflater.from(activity).inflate(R.layout.fragment_main, container, false)

        keywordListAdapter?.setData(keywordHunterDataList)
        secondListAdapter?.setData(secondHunterDataList)

        val keywordDividerItemDecoration = DividerItemDecoration(context!!, LinearLayoutManager.VERTICAL, false)
        keywordDividerItemDecoration.setDrawable(ContextCompat.getDrawable(context!!, R.drawable.seperate_line)!!)
        view.keyword_hunter_lists.addItemDecoration(keywordDividerItemDecoration)
        view.keyword_hunter_lists.layoutManager = LinearLayoutManager(context!!)
        view.keyword_hunter_lists.adapter = keywordListAdapter

        val secondDividerItemDecoration = DividerItemDecoration(context!!, LinearLayoutManager.VERTICAL, false)
        secondDividerItemDecoration.setDrawable(ContextCompat.getDrawable(context!!, R.drawable.seperate_line)!!)
        view.second_hunter_lists.addItemDecoration(keywordDividerItemDecoration)
        view.second_hunter_lists.layoutManager = LinearLayoutManager(context!!)
        view.second_hunter_lists.adapter = secondListAdapter

        val thirdHunterCardPagerAdapter = ThirdHunterCardPagerAdapter(context!!, thirdHunterCardDataList)
        view.card_view_pager.adapter = thirdHunterCardPagerAdapter
        view.card_view_pager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) { }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) { }

            override fun onPageSelected(position: Int) { }
        })

        return view
    }
}