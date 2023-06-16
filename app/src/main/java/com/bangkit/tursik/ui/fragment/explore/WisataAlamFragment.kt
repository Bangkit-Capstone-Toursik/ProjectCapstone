package com.bangkit.tursik.ui.fragment.explore

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bangkit.tursik.R
import com.bangkit.tursik.data.adapter.AdapterListAll
import com.bangkit.tursik.data.adapter.AdapterListWisataAlam
import com.bangkit.tursik.data.response.DataItemAlam
import com.bangkit.tursik.data.response.DataItemAll
import com.bangkit.tursik.databinding.FragmentExploreBinding
import com.bangkit.tursik.databinding.FragmentWisataAlamBinding
import com.bangkit.tursik.other.Result
import com.bangkit.tursik.ui.fragment.detail.DetailFragment
import com.bangkit.tursik.ui.fragment.detail.FullscreenBottomSheetFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WisataAlamFragment : Fragment() {

    private lateinit var binding: FragmentWisataAlamBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapterListAlam: AdapterListWisataAlam

    private val viewModel: ExploreViewModel by activityViewModels()
    private lateinit var progress: ProgressBar

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentWisataAlamBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = binding.rvAlam
        adapterListAlam = AdapterListWisataAlam(object : AdapterListWisataAlam.OnItemClickListener {
            override fun onItemClick(place: DataItemAlam) {
                navigateToDetailFragment()
            }
        })
        recyclerView.adapter = adapterListAlam
        recyclerView.layoutManager = LinearLayoutManager(context)

        progress = binding.progressBar

        viewModel.wisataAlam.observe(viewLifecycleOwner) { resource ->
            when (resource) {
                is Result.Loading -> {
                    progress.visibility = View.VISIBLE
                }
                is Result.Success -> {
                    progress.visibility = View.GONE
                    val placeList = resource.data.data ?: emptyList()
                    adapterListAlam.submitList(placeList)
                    adapterListAlam.notifyDataSetChanged()
                    Log.e("data", resource.data.data.toString()?:"")
                }
                is Result.Error -> {
                    progress.visibility = View.GONE
                    val errorMessage = resource.errorMessage ?: "Unknown error occurred"
                    Toast.makeText(requireContext(), errorMessage, Toast.LENGTH_SHORT).show()
                }
                else ->{

                }
            }
        }

        viewModel.getDestinationAlam()
    }



    private fun navigateToDetailFragment() {
        val detailFragment = FullscreenBottomSheetFragment()
        requireActivity().supportFragmentManager
            .beginTransaction()
            .replace(R.id.buttom_nav, detailFragment)
            .addToBackStack(null)
            .commit()

    }
}