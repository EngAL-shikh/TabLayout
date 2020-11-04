package com.example.dailog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.eftimoff.viewpagertransformers.DepthPageTransformer
import com.eftimoff.viewpagertransformers.ZoomInTransformer
import com.eftimoff.viewpagertransformers.ZoomOutSlideTransformer
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import java.text.FieldPosition
import java.time.zone.ZoneRules
import java.util.zip.ZipInputStream

lateinit var  tabLayout:TabLayout
lateinit var tabViewPager: ViewPager2
lateinit var text:TextView
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tabLayout=findViewById(R.id.tab)
        tabViewPager=findViewById(R.id.vp)


        val colors= listOf(
                R.color.yaloow,
                R.color.blue,
                R.color.red)









 val adpter=ViewpagerAdpter(colors)
    tabViewPager.adapter=adpter






        TabLayoutMediator(tabLayout, tabViewPager){tab,postion->

            tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {


                override fun onTabSelected(p0: TabLayout.Tab?) {
                    Log.d(postion.toString(),"a")

                    Toast.makeText(this@MainActivity,tab.text.toString(),Toast.LENGTH_LONG).show()
                }

                override fun onTabUnselected(p0: TabLayout.Tab?) {

                }

                override fun onTabReselected(p0: TabLayout.Tab?) {

                }


            })
            tab.icon=when(postion){

                0 -> ContextCompat.getDrawable(this,R.drawable.ic_profile)
                1 -> ContextCompat.getDrawable(this,R.drawable.ic_chat)
                2 -> ContextCompat.getDrawable(this,R.drawable.ic_call)
                else ->  ContextCompat.getDrawable(this,R.drawable.ic_profile)
            }
            tab.text=when(postion){


                0->"Profile"
                1->"Chat"
                2->"Call"
                else-> null
            }
        }.attach()


    }


}


