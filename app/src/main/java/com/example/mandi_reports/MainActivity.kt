package com.example.mandi_reports

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    var tabtitle= arrayOf("Business","Review")
    lateinit var tabLayout: TabLayout
    lateinit var viewPager2: ViewPager2
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tabLayout=findViewById(R.id.tablayout)
        viewPager2=findViewById(R.id.viewPager)
        viewPager2.adapter=ViewPagerAdapter(supportFragmentManager,lifecycle)
        TabLayoutMediator(tabLayout,viewPager2){
            tabLayout,position->
            tabLayout.text=tabtitle[position]
        }.attach()
    }
}