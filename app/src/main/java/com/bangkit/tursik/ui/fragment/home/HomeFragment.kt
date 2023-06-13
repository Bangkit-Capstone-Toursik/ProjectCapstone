package com.bangkit.tursik.ui.fragment.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bangkit.tursik.AdapterList
import com.bangkit.tursik.Place
import com.bangkit.tursik.R
import com.bangkit.tursik.getDummyPlaceList
import com.bangkit.tursik.ui.fragment.detail.DetailFragment

class HomeFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: AdapterList
    private val placeList: List<Place> = getDummyPlaceList()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)



        recyclerView = view.findViewById(R.id.recyclerView)
        adapter = AdapterList(placeList)
        recyclerView.adapter = adapter

        val layoutManager = LinearLayoutManager(requireContext())
        recyclerView.layoutManager = layoutManager

        adapter.setOnItemClickListener(object : AdapterList.OnItemClickListener {
            override fun onItemClick(place: Place) {
                navigateToDetailFragment(place)
            }
        })

        return view
    }

    private fun navigateToDetailFragment(place: Place) {
        val detailFragment = DetailFragment.newInstance(place)
        requireActivity().supportFragmentManager
            .beginTransaction()
            .replace(R.id.buttom_nav, detailFragment)
            .addToBackStack(null)
            .commit()
    }

    companion object {
        @JvmStatic
        fun newInstance() = HomeFragment()
    }
}