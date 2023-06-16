package com.bangkit.tursik.ui.fragment.home

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerHome(fragmentManager: Fragment) : FragmentStateAdapter(fragmentManager) {

    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> {
                PopularFragment()
            }
            1 -> {
                RecomendedFragment()
            }
            else -> {
                PopularFragment()
            }
        }
    }
}