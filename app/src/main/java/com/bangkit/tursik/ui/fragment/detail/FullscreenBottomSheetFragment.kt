package com.bangkit.tursik.ui.fragment.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import androidx.navigation.fragment.NavHostFragment
import androidx.viewpager2.widget.ViewPager2
import com.bangkit.tursik.R
import com.bangkit.tursik.ViewPagerAdapter
import com.bangkit.tursik.data.response.DataItem
import com.bangkit.tursik.data.response.DataItemDestinationRecomended
import com.bangkit.tursik.databinding.FragmentFullscreenBottomSheetBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FullscreenBottomSheetFragment : BottomSheetDialogFragment() {

    private lateinit var place: DataItem
    private lateinit var placRec: DataItemDestinationRecomended
    private lateinit var binding: FragmentFullscreenBottomSheetBinding

    companion object {
        private const val ARG_PLACE = "arg_place"
        private const val ARG_PLACE_RECOMENDED = "arg_place_recomended"

        fun newInstance(place: DataItem): FullscreenBottomSheetFragment {
            val fragment = FullscreenBottomSheetFragment()
            val args = Bundle().apply {
                putParcelable(ARG_PLACE, place)
            }
            fragment.arguments = args
            return fragment
        }

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFullscreenBottomSheetBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navHost = NavHostFragment()
        childFragmentManager.beginTransaction().replace(R.id.bottomSheetNavHost, navHost)
            .commitNow()

        val place = arguments?.getParcelable<DataItem>(ARG_PLACE)
        place?.let {
            this.place = it


            val tvPlace = view.findViewById<TextView>(R.id.tv_place)
            val tvPrice = view.findViewById<TextView>(R.id.tv_price)
            val tvLocation = view.findViewById<TextView>(R.id.tv_location)
            val tvRating = view.findViewById<TextView>(R.id.tv_rating)

            tvPlace.text = place.name
            tvPrice.text = place.price
            tvLocation.text = place.province
            tvRating.text = place.rating
        }

      setStyle(DialogFragment.STYLE_NORMAL, R.style.CustomBottomSheetDialogTheme)

      val tabLayout = view.findViewById<TabLayout>(R.id.tabLayout)
      val viewPager = view.findViewById<ViewPager2>(R.id.viewPager)

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

        setStyle(DialogFragment.STYLE_NORMAL, R.style.CustomBottomSheetDialogTheme)
        dialog?.setOnShowListener { dialog ->
            val layout: FrameLayout? = (dialog as BottomSheetDialog)
                .findViewById(com.google.android.material.R.id.design_bottom_sheet)
            layout?.let {
                val behavior = BottomSheetBehavior.from(it)
                behavior.state = BottomSheetBehavior.STATE_EXPANDED
                behavior.skipCollapsed = true
            }
        }
    }

}



