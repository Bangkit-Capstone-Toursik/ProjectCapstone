package com.bangkit.tursik.ui.fragment.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bangkit.tursik.data.response.DetailDestinationResponse
import com.bangkit.tursik.domain.usecase.detaildestination.DetailDestinationUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import com.bangkit.tursik.other.Result
import kotlinx.coroutines.flow.last


@HiltViewModel
class DetailViewModel @Inject constructor(
    private val detailDestinationUseCase: DetailDestinationUseCase)
    : ViewModel(){

    private val _userDataDetail = MutableLiveData<Result<DetailDestinationResponse>>()
    val userDataDetail get() = _userDataDetail

    fun getUserData(username: String) {
        _userDataDetail.value = Result.Loading
        viewModelScope.launch {
            _userDataDetail.value = detailDestinationUseCase.getDestinationDetail(username).last()
        }
    }
}