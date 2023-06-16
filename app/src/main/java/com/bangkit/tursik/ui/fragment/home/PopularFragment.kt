package com.bangkit.tursik.ui.fragment.home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.AdapterView.OnItemClickListener
import android.widget.ProgressBar
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bangkit.tursik.data.adapter.AdapterList
import com.bangkit.tursik.R
import com.bangkit.tursik.databinding.FragmentPopularBinding
import com.bangkit.tursik.data.response.DataItem
import com.bangkit.tursik.other.Result
import com.bangkit.tursik.ui.fragment.detail.FullscreenBottomSheetFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PopularFragment : Fragment(), OnItemClickListener {

    private lateinit var binding: FragmentPopularBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapterList: AdapterList

    private val viewModel: HomeViewModel by activityViewModels()
    private lateinit var progress: ProgressBar

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPopularBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = binding.rvPopular
        adapterList = AdapterList(object : AdapterList.OnItemClickListener {
            override fun onItemClick(place: DataItem) {
                navigateToDetailFragment(place.name?:"")
              /*  findNavController().navigate(
                    PopularFragmentDirections.
                    actionPopularFragmentToFullscreenBottomSheetFragment2(place.name?:""))*/
            }
        })
        recyclerView.adapter = adapterList
        recyclerView.layoutManager = LinearLayoutManager(context)


        progress = binding.progressBar

        viewModel.res.observe(viewLifecycleOwner) { resource ->
            when (resource) {
                is Result.Loading -> {
                    progress.visibility = View.VISIBLE
                }
                is Result.Success -> {
                    progress.visibility = View.GONE
                    val placeList = resource.data.data ?: emptyList()
                    adapterList.submitList(placeList)
                    adapterList.notifyDataSetChanged()
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

        viewModel.getDestinationPopular()
    }



    private fun navigateToDetailFragment(place: String) {
        val detailFragment = FullscreenBottomSheetFragment()
        val bundle = Bundle()
        bundle.putString("place",place)
        detailFragment.arguments = bundle
        requireActivity().supportFragmentManager
            .beginTransaction()
            .replace(R.id.buttom_nav, detailFragment)
            .addToBackStack(null)
            .commit()

    }

    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

    }


}