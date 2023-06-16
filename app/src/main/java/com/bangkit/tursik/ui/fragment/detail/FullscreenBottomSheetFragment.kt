package com.bangkit.tursik.ui.fragment.detail

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.NavHostFragment
import androidx.viewpager2.widget.ViewPager2
import com.bangkit.tursik.R
import com.bangkit.tursik.ViewPagerAdapter
import com.bangkit.tursik.data.response.DataItem
import com.bangkit.tursik.data.response.DataItemDestinationRecomended
import com.bangkit.tursik.data.response.DetailDestinationResponse
import com.bangkit.tursik.databinding.FragmentFullscreenBottomSheetBinding
import com.bangkit.tursik.other.Result
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.google.api.ResourceProto.resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FullscreenBottomSheetFragment() : BottomSheetDialogFragment() {

    private lateinit var place: String
    private lateinit var binding: FragmentFullscreenBottomSheetBinding
    private val viewModel: DetailViewModel by viewModels()

    companion object {
        private const val ARG_PLACE = "arg_place"

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


        val place = arguments?.getString("place")
        place?.let {
            this.place = it.toString()

        }
        Log.e("place", place?:"")

      setStyle(DialogFragment.STYLE_NORMAL, R.style.CustomBottomSheetDialogTheme)

      val tabLayout = view.findViewById<TabLayout>(R.id.tabLayout)
      val viewPager = view.findViewById<ViewPager2>(R.id.viewPager)

      val viewPagerAdapter = ViewPagerAdapter(childFragmentManager, viewLifecycleOwner.lifecycle)
      viewPagerAdapter.addFragment(DetailDescriptionFragment())
      viewPagerAdapter.addFragment(DetailReviewFragment())
      viewPagerAdapter.addFragment(DetailPhotoFragment())

      viewPager.adapter = viewPagerAdapter


        viewModel.userDataDetail.observe(viewLifecycleOwner) { resource ->
            when (resource) {
                is Result.Loading -> {
                }
                is Result.Success -> {
                    bindData(resource.data)
                    Log.e("data", resource.data.toString()?:"")
                }
                is Result.Error -> {
                    val errorMessage = resource.errorMessage ?: "Unknown error occurred"
                    Toast.makeText(requireContext(), errorMessage, Toast.LENGTH_SHORT).show()
                }
                else ->{

                }
            }
        }

        if (place != null) {
            viewModel.getUserData(place)
        }

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
    fun bindData(data: DetailDestinationResponse){
        binding.tvPlace.text = data.data?.placeData?.name
        binding.tvLocation.text = data.data?.placeData?.province
        binding.tvRating.text = data.data?.placeData?.rating
        binding.tvPrice.text = data.data?.placeData?.price
    }

}



