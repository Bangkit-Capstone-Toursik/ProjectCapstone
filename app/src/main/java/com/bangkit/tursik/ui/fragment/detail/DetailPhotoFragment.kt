package com.bangkit.tursik.ui.fragment.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bangkit.tursik.Place
import com.bangkit.tursik.R


class DetailPhotoFragment : Fragment() {
    private lateinit var place: Place

    companion object {
        fun newInstance(place: Place): DetailPhotoFragment {
            val fragment = DetailPhotoFragment()
            fragment.place = place
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_detail_photo, container, false)
        // Dapatkan referensi ke ImageView atau RecyclerView
        // Populasi ImageView atau RecyclerView dengan data foto dari place.photos
        return view
    }
}