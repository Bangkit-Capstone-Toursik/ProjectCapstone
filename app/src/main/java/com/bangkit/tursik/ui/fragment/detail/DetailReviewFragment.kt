package com.bangkit.tursik.ui.fragment.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bangkit.tursik.Place
import com.bangkit.tursik.R
import com.bangkit.tursik.VisitorReview
import com.bangkit.tursik.data.adapter.AdapterReview
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class DetailReviewFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var visitorReviewAdapter: AdapterReview

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_detail_review, container, false)
        recyclerView = view.findViewById(R.id.rv_review)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        displayVisitorReviews()
    }

    private fun setupRecyclerView() {
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        visitorReviewAdapter = AdapterReview(emptyList()) // Tambahkan data review pengunjung di sini
        recyclerView.adapter = visitorReviewAdapter
    }

    private fun displayVisitorReviews() {

        val visitorReviews = getVisitorReviews()


        visitorReviewAdapter.visitorReviews = visitorReviews


        visitorReviewAdapter.notifyDataSetChanged()
    }

    private fun getVisitorReviews(): List<VisitorReview> {

        return listOf(
            VisitorReview("John Doe", 4.5f, "Great place to visit!", "2022-05-15"),
            VisitorReview("Jane Smith", 5.0f, "Amazing experience!", "2022-06-20"),
            VisitorReview("Mike Johnson", 3.8f, "Could be better.", "2022-07-05")
        )
    }
}