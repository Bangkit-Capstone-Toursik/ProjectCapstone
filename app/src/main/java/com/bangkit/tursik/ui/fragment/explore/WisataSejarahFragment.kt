package com.bangkit.tursik.ui.fragment.explore

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bangkit.tursik.R
import com.bangkit.tursik.data.adapter.AdapterListWisataSejarah
import com.bangkit.tursik.data.response.DataItemSejarah
import com.bangkit.tursik.databinding.FragmentWisataSejarahBinding
import com.bangkit.tursik.other.Result
import com.bangkit.tursik.ui.fragment.detail.DetailFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WisataSejarahFragment : Fragment() {
    private lateinit var binding: FragmentWisataSejarahBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapterListSejarah: AdapterListWisataSejarah

    private val viewModel: ExploreViewModel by activityViewModels()
    private lateinit var progress: ProgressBar

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentWisataSejarahBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = binding.rvSejarah
        adapterListSejarah =
            AdapterListWisataSejarah(object : AdapterListWisataSejarah.OnItemClickListener {
                override fun onItemClick(place: DataItemSejarah) {
                    navigateToDetailFragment()
                }
            })
        recyclerView.adapter = adapterListSejarah
        recyclerView.layoutManager = LinearLayoutManager(context)

        progress = binding.progressBar

        viewModel.wisataSejarah.observe(viewLifecycleOwner) { resource ->
            when (resource) {
                is Result.Loading -> {
                    progress.visibility = View.VISIBLE
                }

                is Result.Success -> {
                    progress.visibility = View.GONE
                    val placeList = resource.data.data ?: emptyList()
                    adapterListSejarah.submitList(placeList)
                    adapterListSejarah.notifyDataSetChanged()
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

        viewModel.getDestinationSejarah()
    }


    private fun navigateToDetailFragment() {
        val detailFragment = DetailFragment()
        requireActivity().supportFragmentManager
            .beginTransaction()
            .replace(R.id.buttom_nav, detailFragment)
            .addToBackStack(null)
            .commit()
    }
}