package com.dragonbro.hunters.ui

import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager.widget.ViewPager
import com.dragonbro.hunters.R
import com.dragonbro.hunters.data.KeywordHunterData
import com.dragonbro.hunters.util.DividerItemDecoration
import com.dragonbro.hunters.data.SecondHunterData
import com.dragonbro.hunters.adapters.KeywordHuntersRecyclerAdapter
import com.dragonbro.hunters.adapters.ThirdHunterCardPagerAdapter
import com.dragonbro.hunters.adapters.SecondHuntersRecyclerAdapter
import com.dragonbro.hunters.data.ThirdHunterData
import com.dragonbro.hunters.navigation.*
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {

    override fun onNavigationItemSelected(p0: MenuItem): Boolean {
        when(p0.itemId) {
            R.id.action_main -> {
                var mainFragment = MainFragment()
                supportFragmentManager.beginTransaction().replace(R.id.main_content, mainFragment).commit()
                return true
            }
            R.id.action_recruit -> {
                var recruitragment = RecruitFragment()
                supportFragmentManager.beginTransaction().replace(R.id.main_content, recruitragment).commit()
                return true
            }
            R.id.action_search -> {
                var searchFragment = SearchFragment()
                supportFragmentManager.beginTransaction().replace(R.id.main_content, searchFragment).commit()
                return true
            }
            R.id.action_doing -> {
                var doingFragment = DoingFragment()
                supportFragmentManager.beginTransaction().replace(R.id.main_content, doingFragment).commit()
                return true
            }
            R.id.action_profile -> {
                var profileFragment = ProfileFragment()
                supportFragmentManager.beginTransaction().replace(R.id.main_content, profileFragment).commit()
                return true
            }
        }
        return false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bottom_navigation.setOnNavigationItemSelectedListener(this)

        var mainFragment = MainFragment()
        supportFragmentManager.beginTransaction().replace(R.id.main_content, mainFragment).commit()
    }

}