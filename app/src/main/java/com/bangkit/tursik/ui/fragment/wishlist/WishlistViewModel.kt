package com.bangkit.tursik.ui.fragment.wishlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bangkit.tursik.data.entity.WishlistEntity
import com.bangkit.tursik.domain.usecase.wishlist.WishlistUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.last
import kotlinx.coroutines.launch
import com.bangkit.tursik.other.Result

@HiltViewModel
class WishlistViewModel @Inject constructor(
    private val favouriteUserUseCase: WishlistUseCase
) : ViewModel() {

    private val _getAllFavouriteUser = MutableLiveData<Result<List<WishlistEntity>>>()
    val getAllFavouriteUser: LiveData<Result<List<WishlistEntity>>> get() = _getAllFavouriteUser

    fun getAllFavouriteUser() {
        _getAllFavouriteUser.value = Result.Loading
        viewModelScope.launch {
            _getAllFavouriteUser.value = favouriteUserUseCase.getAllFavouriteUser().last()
        }
    }

    private val _setUserAsFavourite = MutableLiveData<Result<Long>>()
    val setUserAsFavourite: LiveData<Result<Long>> get() = _setUserAsFavourite

    fun setUserAsFavourite(user: WishlistEntity) {
        _setUserAsFavourite.value = Result.Loading
        viewModelScope.launch {
            _setUserAsFavourite.value = favouriteUserUseCase.setUserAsFavourite(user = user).last()
        }
    }

    private val _deleteFavouriteUser = MutableLiveData<Result<Int>>()
    val deleteFavouriteUser: LiveData<Result<Int>> get() = _deleteFavouriteUser

    fun deleteFavouriteUser(user: WishlistEntity) {
        _deleteFavouriteUser.value = Result.Loading
        viewModelScope.launch {
            _deleteFavouriteUser.value =
                favouriteUserUseCase.deleteFavouriteUser(user = user).last()
        }
    }
}