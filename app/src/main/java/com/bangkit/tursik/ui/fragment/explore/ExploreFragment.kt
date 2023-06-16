package com.bangkit.tursik.ui.fragment.explore

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.ProgressBar
import androidx.appcompat.widget.SearchView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bangkit.tursik.Place
import com.bangkit.tursik.R
import com.bangkit.tursik.data.adapter.AdapterListAll
import com.bangkit.tursik.data.response.DataItemAll
import com.bangkit.tursik.databinding.FragmentExploreBinding
import com.bangkit.tursik.databinding.FragmentPopularBinding
import com.bangkit.tursik.other.Result
import com.bangkit.tursik.ui.fragment.detail.DetailFragment
import com.google.api.ResourceProto.resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ExploreFragment : Fragment() {

    private lateinit var binding: FragmentExploreBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapterListAll: AdapterListAll

    private val viewModel: ExploreViewModel by activityViewModels()
    private lateinit var progress: ProgressBar
    private lateinit var searchView: SearchView
    private var originalList: List<Place> = emptyList()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentExploreBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        val layout = view.findViewById<LinearLayout>(R.id.exploreFragment)
        if (layout != null) {
            val ib_wAlam: ImageButton = layout.findViewById(R.id.ib_wAlam)
            val ib_wReligi: ImageButton = layout.findViewById(R.id.ib_wReligi)
            val ib_wPendidikan: ImageButton = layout.findViewById(R.id.ib_wPendidikan)
            val ib_wSejarah: ImageButton = layout.findViewById(R.id.ib_wSejarah)

            ib_wAlam.setOnClickListener {
                navigateToWisataAlamFragment()
            }

            ib_wReligi.setOnClickListener {
                navigateToWisataReligiFragment()
            }

            ib_wPendidikan.setOnClickListener {
                navigateToWisataPendidikanFragment()
            }

            ib_wSejarah.setOnClickListener {
                navigateToWisataSejarahFragment()
            }
        } else {

        }

        recyclerView = binding.rvAll
        adapterListAll = AdapterListAll(object : AdapterListAll.OnItemClickListener {
            override fun onItemClick(place: DataItemAll) {
                navigateToDetailFragment()
            }
        })
        recyclerView.adapter = adapterListAll
        recyclerView.layoutManager = LinearLayoutManager(context)

        val searchView = binding.searchView

        progress = binding.progressBar





        viewModel.all.observe(viewLifecycleOwner) { resource ->
            when (resource) {
                is Result.Loading -> {
                    progress.visibility = View.VISIBLE
                }

                is Result.Success -> {
                    progress.visibility = View.GONE
                    val placeList = resource.data.data ?: emptyList()
                    adapterListAll.submitList(placeList)
                    adapterListAll.notifyDataSetChanged()
                    Log.e("data", resource.data.data.toString())
                }

                is Result.Error -> {
                    progress.visibility = View.GONE
                    val errorMessage = resource.errorMessage ?: "Unknown error occurred"
                    Toast.makeText(requireContext(), errorMessage, Toast.LENGTH_SHORT).show()
                }

                else -> {

                }
            }
        }
        viewModel.getDestinationAll()
    }


    private fun navigateToDetailFragment() {
        val detailFragment = DetailFragment()
        requireActivity().supportFragmentManager
            .beginTransaction()
            .replace(R.id.buttom_nav, detailFragment)
            .addToBackStack(null)
            .commit()
    }

    private fun navigateToWisataAlamFragment() {
        val fragment = WisataAlamFragment()
        val fragmentManager = requireActivity().supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.buttom_nav, fragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }

    private fun navigateToWisataReligiFragment() {
        val fragment = WisataReligiFragment()
        val fragmentManager = requireActivity().supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.buttom_nav, fragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }

    private fun navigateToWisataPendidikanFragment() {
        val fragment = WisataPendidikanFragment()
        val fragmentManager = requireActivity().supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.buttom_nav, fragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }

    private fun navigateToWisataSejarahFragment() {
        val fragment = WisataSejarahFragment()
        val fragmentManager = requireActivity().supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.buttom_nav, fragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }

}