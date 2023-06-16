package com.bangkit.tursik.ui.fragment.home

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
import com.bangkit.tursik.data.adapter.AdapterListRecomended
import com.bangkit.tursik.data.response.DataItemDestinationRecomended
import com.bangkit.tursik.databinding.FragmentRecomendedBinding
import com.bangkit.tursik.other.Result

import com.bangkit.tursik.ui.fragment.detail.FullscreenBottomSheetFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RecomendedFragment : Fragment() {

    private lateinit var binding: FragmentRecomendedBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapterListRec: AdapterListRecomended

    private val viewModel: HomeViewModel by activityViewModels()
    private lateinit var progress: ProgressBar

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRecomendedBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = binding.rvRecomended
        adapterListRec = AdapterListRecomended(object : AdapterListRecomended.OnItemClickListener {
            override fun onItemClick(placeRec: DataItemDestinationRecomended) {
                navigateToDetailFragment()
            }
        })
        recyclerView.adapter = adapterListRec
        recyclerView.layoutManager = LinearLayoutManager(context)


        progress = binding.progressBar

        viewModel.resRecomed.observe(viewLifecycleOwner) { resource ->
            when (resource) {
                is Result.Loading -> {
                    progress.visibility = View.VISIBLE
                }
                is Result.Success -> {
                    progress.visibility = View.GONE
                    val placeList = resource.data.data ?: emptyList()
                    adapterListRec.submitList(placeList)
                    adapterListRec.notifyDataSetChanged()
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

        viewModel.getDestinationRecomended()
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