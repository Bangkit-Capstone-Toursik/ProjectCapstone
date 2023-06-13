package com.bangkit.tursik.ui.fragment.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bangkit.tursik.Place
import com.bangkit.tursik.R


private const val ARG_PLACE = "place"
class DetailReviewFragment : Fragment() {
    private lateinit var place: Place

    companion object {
        fun newInstance(place: Place): DetailReviewFragment {
            val fragment = DetailReviewFragment()
            fragment.place = place
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_detail_review, container, false)
        // Dapatkan referensi ke RecyclerView atau ListView
        // Populasi RecyclerView atau ListView dengan data ulasan dari place.reviews
        return view
    }
}