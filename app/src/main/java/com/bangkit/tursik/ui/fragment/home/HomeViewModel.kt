package com.bangkit.tursik.ui.fragment.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bangkit.tursik.data.response.DestinationPopularResponse
import com.bangkit.tursik.data.response.DestinationRecomededResponse
import com.bangkit.tursik.domain.usecase.getdestinationpopular.GetDestinationPopularUseCase
import com.bangkit.tursik.domain.usecase.getdestinationrecomend.GetDestinationRecomendedUseCase
import com.bangkit.tursik.other.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.last
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getDestinationPopularUseCase: GetDestinationPopularUseCase,
    private val getDestinationRecomendedUseCase: GetDestinationRecomendedUseCase)
    : ViewModel() {

    private val _res = MutableLiveData<Result<DestinationPopularResponse>>()
    val res: LiveData<Result<DestinationPopularResponse>> get() = _res

    private val _resRecomend = MutableLiveData<Result<DestinationRecomededResponse>>()
    val resRecomed: LiveData<Result<DestinationRecomededResponse>> get() = _resRecomend

    fun getDestinationPopular() {
        _res.value = Result.Loading
        viewModelScope.launch {
            _res.value = getDestinationPopularUseCase.getDestinationPopular().last()

        }
    }

    fun getDestinationRecomended() {
        _resRecomend.value = Result.Loading
        viewModelScope.launch {
            _resRecomend.value = getDestinationRecomendedUseCase.getDestinationRecomended().last()

        }
    }
}