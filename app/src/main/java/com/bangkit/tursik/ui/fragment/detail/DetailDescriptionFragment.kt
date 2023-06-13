package com.bangkit.tursik.ui.fragment.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.bangkit.tursik.Place
import com.bangkit.tursik.R

class DetailDescriptionFragment : Fragment() {
    private lateinit var place: Place

    companion object {
        fun newInstance(place: Place): DetailDescriptionFragment {
            val fragment = DetailDescriptionFragment()
            fragment.place = place
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_detail_description, container, false)
        return view
    }
}