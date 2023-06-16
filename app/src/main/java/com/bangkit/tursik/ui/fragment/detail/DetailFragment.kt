package com.bangkit.tursik.ui.fragment.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bangkit.tursik.R
import com.bangkit.tursik.data.response.DataItem
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class DetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_detail, container, false)


        showBottomSheet()
        return view
        }

    private fun showBottomSheet() {
       FullscreenBottomSheetFragment().show(childFragmentManager, null)
    }

    companion object {
        private const val ARG_PLACE = "arg_place"

        fun newInstance(place: DataItem): DetailFragment {
            val fragment = DetailFragment()
            val args = Bundle().apply {
                putParcelable(ARG_PLACE, place)
            }
            fragment.arguments = args
            return fragment
        }
    }
}