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
import com.bangkit.tursik.data.adapter.AdapterListWisataAlam
import com.bangkit.tursik.data.adapter.AdapterListWisataPendidikan
import com.bangkit.tursik.data.response.DataItemAlam
import com.bangkit.tursik.data.response.DataItemPendidikan
import com.bangkit.tursik.databinding.FragmentWisataAlamBinding
import com.bangkit.tursik.databinding.FragmentWisataPendidikanBinding
import com.bangkit.tursik.other.Result
import com.bangkit.tursik.ui.fragment.detail.DetailFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WisataPendidikanFragment : Fragment() {
    private lateinit var binding: FragmentWisataPendidikanBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapterListPendidikan: AdapterListWisataPendidikan

    private val viewModel: ExploreViewModel by activityViewModels()
    private lateinit var progress: ProgressBar

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentWisataPendidikanBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = binding.rvPendidikan
        adapterListPendidikan = AdapterListWisataPendidikan(object : AdapterListWisataPendidikan.OnItemClickListener {
            override fun onItemClick(place: DataItemPendidikan) {
                navigateToDetailFragment()
            }
        })
        recyclerView.adapter = adapterListPendidikan
        recyclerView.layoutManager = LinearLayoutManager(context)

        progress = binding.progressBar

        viewModel.wisataPendidikan.observe(viewLifecycleOwner) { resource ->
            when (resource) {
                is Result.Loading -> {
                    progress.visibility = View.VISIBLE
                }
                is Result.Success -> {
                    progress.visibility = View.GONE
                    val placeList = resource.data.data ?: emptyList()
                    adapterListPendidikan.submitList(placeList)
                    adapterListPendidikan.notifyDataSetChanged()
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

        viewModel.getDestinationPendidikan()
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