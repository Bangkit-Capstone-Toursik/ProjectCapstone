package com.bangkit.tursik.ui.fragment.detail

import android.os.Bundle
import android.service.autofill.UserData
import android.text.TextUtils.replace
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.bangkit.tursik.Place
import com.bangkit.tursik.R
import com.bangkit.tursik.data.repository.WishlistRepository
import com.bangkit.tursik.data.response.DataItem
import com.bangkit.tursik.data.response.DetailDestinationResponse
import com.bangkit.tursik.databinding.FragmentDetailBinding
import com.bangkit.tursik.databinding.FragmentDetailDescriptionBinding
import com.bangkit.tursik.databinding.FragmentFullscreenBottomSheetBinding
import com.bangkit.tursik.other.Result
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailDescriptionFragment : Fragment() {
    private lateinit var place: Place

    private val viewModel: DetailViewModel by activityViewModels()
    private lateinit var binding: FragmentDetailDescriptionBinding

    companion object {
        fun newInstance(place: Place): DetailDescriptionFragment {
            val fragment = DetailDescriptionFragment()
            fragment.place = place
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentDetailDescriptionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val place = parentFragment?.arguments?.getString("place")
        viewModel.userDataDetail.observe(viewLifecycleOwner) { resource ->
            when (resource) {
                is Result.Loading -> {
                }
                is Result.Success -> {
                    bindData(resource.data)
                    Log.e("data", resource.data.toString()?:"")
                }
                is Result.Error -> {
                    val errorMessage = resource.errorMessage ?: "Unknown error occurred"
                    Toast.makeText(requireContext(), errorMessage, Toast.LENGTH_SHORT).show()
                }
                else ->{

                }
            }
        }
        if (place != null) {
            viewModel.getUserData(place)
        }
    }
    fun bindData(data: DetailDestinationResponse){
        binding.tagStateDescription.text = data.data?.types?.toString()
            ?.replace("[","")
            ?.replace("]","")
    }
}