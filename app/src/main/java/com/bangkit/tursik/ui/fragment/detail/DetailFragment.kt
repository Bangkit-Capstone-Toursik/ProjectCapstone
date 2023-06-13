package com.bangkit.tursik.ui.fragment.detail

import android.content.Context
import android.os.Build
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Button
import android.widget.LinearLayout
import androidx.core.widget.NestedScrollView
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.bangkit.tursik.Place
import com.bangkit.tursik.R
import com.bangkit.tursik.ViewPagerAdapter
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator


private const val ARG_PLACE = "place"

class DetailFragment : Fragment() {

    private lateinit var place: Place

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            place = it.getParcelable(ARG_PLACE)!!
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_detail, container, false)

        val buttonWishlist = view.findViewById<Button>(R.id.button_sheet)
        buttonWishlist.setOnClickListener {
            showBottomSheet()
        }

        return view
    }

    private fun showBottomSheet() {
        val bottomSheet = BottomSheetDialog(requireContext())
        val view = layoutInflater.inflate(R.layout.buttom_sheet_layout, null)
        bottomSheet.setContentView(view)


        val behavior = BottomSheetBehavior.from(view.parent as View)
        behavior.peekHeight = getExpandedHeight()

        bottomSheet.setOnShowListener {
            val tabLayout = view.findViewById<TabLayout>(R.id.tab_layout)
            val viewPager = view.findViewById<ViewPager2>(R.id.viewPager2)

            val viewPagerAdapter = ViewPagerAdapter(childFragmentManager, lifecycle)
            viewPagerAdapter.addFragment(DetailDescriptionFragment())
            viewPagerAdapter.addFragment(DetailReviewFragment())
            viewPagerAdapter.addFragment(DetailPhotoFragment())

            viewPager.adapter = viewPagerAdapter

            TabLayoutMediator(tabLayout, viewPager) { tab, position ->
                when (position) {
                    0 -> tab.text = "Description"
                    1 -> tab.text = "Review"
                    2 -> tab.text = "Photo"
                }
            }.attach()

            val nestedScrollView = view.findViewById<NestedScrollView>(R.id.nestedScrollView)
            nestedScrollView.isNestedScrollingEnabled = true
        }

        bottomSheet.show()
    }

    private fun getExpandedHeight(): Int {
        val displayMetrics = DisplayMetrics()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            val display = requireContext().display
            display?.getRealMetrics(displayMetrics)
        } else {
            val windowManager = requireContext().getSystemService(Context.WINDOW_SERVICE) as WindowManager
            windowManager.defaultDisplay.getMetrics(displayMetrics)
        }
        val screenHeight = displayMetrics.heightPixels
        val expandedHeight = screenHeight / 2

        return expandedHeight
    }

    companion object {
        @JvmStatic
        fun newInstance(place: Place) =
            DetailFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(ARG_PLACE, place)
                }
            }
    }
}