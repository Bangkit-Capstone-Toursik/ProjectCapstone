package com.bangkit.tursik.ui.fragment.wishlist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.bangkit.tursik.other.Result
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.bangkit.tursik.R
import com.bangkit.tursik.data.adapter.WishlistAdapter
import com.bangkit.tursik.data.entity.WishlistEntity
import com.bangkit.tursik.databinding.FragmentWishlistBinding
import com.bangkit.tursik.other.ItemClickListener
import com.bangkit.tursik.other.showPopUpMenu
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WishlistFragment : Fragment(R.layout.fragment_wishlist), ItemClickListener {

    private lateinit var binding: FragmentWishlistBinding
    private val vm: WishlistViewModel by viewModels()
    private val adapter: WishlistAdapter by lazy { WishlistAdapter(this) }

    private var isSavedInstanceStateNull = false
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentWishlistBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        isSavedInstanceStateNull = savedInstanceState === null
        setupObserver()
        setupView()
    }

    override fun onResume() {
        super.onResume()
        if (isSavedInstanceStateNull) vm.getAllFavouriteUser()
    }

    private fun setupObserver() {
        vm.getAllFavouriteUser.observe(viewLifecycleOwner) {
            when (it) {
                is Result.Loading -> {
                    binding.progressBar.visibility = View.VISIBLE
                }
                is Result.Success -> {
                    binding.progressBar.visibility = View.GONE
                    adapter.submitList(it.data)
                }
                is Result.Empty -> {
                    binding.progressBar.visibility = View.GONE
                    binding.tvNoDataFound.visibility = View.VISIBLE
                }
                is Result.Error -> {
                    binding.progressBar.visibility = View.GONE
                }
            }
        }

        vm.deleteFavouriteUser.observe(viewLifecycleOwner) {
            when (it) {
                is Result.Loading -> {
                    binding.progressBar.visibility = View.VISIBLE
                }
                is Result.Success -> {
                    binding.progressBar.visibility = View.GONE
                    vm.getAllFavouriteUser()
                }
                is Result.Empty -> {
                    binding.progressBar.visibility = View.GONE
                }
                is Result.Error -> {
                    binding.progressBar.visibility = View.GONE
                }
            }
        }
    }

    private fun setupView() {
        binding.rvWishlist.adapter = adapter
    }

    override fun onItemClick(data: String) {
    }

    /*override fun onItemClick(data: String) {
        findNavController().navigate(
            UserListFragmentDirections.toUserDetailFragment().setUsername(data)
        )
    }*/

    override fun onItemMenuClick(view: View, user: WishlistEntity) {
        showPopUpMenu(view, listOf("Remove from favorite")) {
            vm.deleteFavouriteUser(user = user)
        }
    }
}
