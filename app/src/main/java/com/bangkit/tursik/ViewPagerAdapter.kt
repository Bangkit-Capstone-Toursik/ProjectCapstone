package com.bangkit.tursik

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.bangkit.tursik.ui.fragment.detail.DetailDescriptionFragment
import com.bangkit.tursik.ui.fragment.detail.DetailFragment
import com.bangkit.tursik.ui.fragment.detail.DetailPhotoFragment
import com.bangkit.tursik.ui.fragment.detail.DetailReviewFragment

class ViewPagerAdapter(
    fragmentManager: FragmentManager,
    lifecycle: Lifecycle)
    : FragmentStateAdapter(fragmentManager, lifecycle) {
    private val fragmentList = ArrayList<Fragment>()

    fun addFragment(fragment: Fragment) {
        fragmentList.add(fragment)
    }
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> DetailDescriptionFragment()
            1 -> DetailReviewFragment()
            2 -> DetailPhotoFragment()
            else -> throw IllegalArgumentException("Invalid fragment position: $position")
        }
    }
}