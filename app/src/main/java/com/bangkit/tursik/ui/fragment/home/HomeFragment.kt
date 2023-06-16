package com.bangkit.tursik.ui.fragment.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.activityViewModels
import androidx.viewpager2.widget.ViewPager2
import com.bangkit.tursik.R
import com.bangkit.tursik.ui.fragment.notification.NotificationFragment
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private lateinit var tabLayout: TabLayout
    private lateinit var viewPager: ViewPager2
    private lateinit var adapter: ViewPagerHome

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        val ivNotification = view.findViewById<ImageView>(R.id.iv_notification)
        tabLayout = view.findViewById(R.id.tab_layout_home)
        viewPager = view.findViewById(R.id.viewPager_home)

        val adapter = ViewPagerHome(this)
        viewPager.adapter = adapter

        ivNotification.setOnClickListener {
            val fragmentTujuan = NotificationFragment()
            val fragmentManager = parentFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.buttom_nav, fragmentTujuan)
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            when(position){
                0 -> {
                    tab.text = "Popular"
                }
                1 -> {
                    tab.text = "Recomended"
                }
            }
        }.attach()
        return view
    }

    companion object {
        @JvmStatic
        fun newInstance() = HomeFragment()
    }
}