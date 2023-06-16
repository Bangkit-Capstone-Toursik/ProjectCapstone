package com.bangkit.tursik.ui.fragment.explore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bangkit.tursik.Place
import com.bangkit.tursik.data.response.DataItemAll
import com.bangkit.tursik.data.response.DestinationAlamResponse
import com.bangkit.tursik.data.response.DestinationAllResponse
import com.bangkit.tursik.data.response.DestinationPendidikanResponse
import com.bangkit.tursik.data.response.DestinationPopularResponse
import com.bangkit.tursik.data.response.DestinationReligiResponse
import com.bangkit.tursik.data.response.DestinationSejarahResponse
import com.bangkit.tursik.domain.usecase.getdestinationalam.GetDestinationAlamUseCase
import com.bangkit.tursik.domain.usecase.getdestinationall.GetDestinationAllUseCase
import com.bangkit.tursik.domain.usecase.getdestinationpendidikan.GetDestinationPendidikanUseCase
import com.bangkit.tursik.domain.usecase.getdestinationpopular.GetDestinationPopularUseCase
import com.bangkit.tursik.domain.usecase.getdestinationrecomend.GetDestinationRecomendedUseCase
import com.bangkit.tursik.domain.usecase.getdestinationreligi.GetDestinationReligiUseCase
import com.bangkit.tursik.domain.usecase.getdestinationsejarah.GetDestinationSejarahUseCase
import com.bangkit.tursik.other.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.last
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ExploreViewModel @Inject constructor(
    private val getDestinationAllUseCase: GetDestinationAllUseCase,
    private val getDestinationAlamUseCase: GetDestinationAlamUseCase,
    private val getDestinationPendidikanUseCase: GetDestinationPendidikanUseCase,
    private val getDestinationReligiUseCase: GetDestinationReligiUseCase,
    private val getDestinationSejarahUseCase: GetDestinationSejarahUseCase)
    : ViewModel() {

    private val _all = MutableLiveData<Result<DestinationAllResponse>>()
    val all: LiveData<Result<DestinationAllResponse>> get() = _all

    private val _wisataAlam = MutableLiveData<Result<DestinationAlamResponse>>()
    val wisataAlam: LiveData<Result<DestinationAlamResponse>> get() = _wisataAlam

    private val _wisataPendidikan = MutableLiveData<Result<DestinationPendidikanResponse>>()
    val wisataPendidikan: LiveData<Result<DestinationPendidikanResponse>> get() = _wisataPendidikan

    private val _wisataReligi = MutableLiveData<Result<DestinationReligiResponse>>()
    val wisataReligi: LiveData<Result<DestinationReligiResponse>> get() = _wisataReligi

    private val _wisataSejarah = MutableLiveData<Result<DestinationSejarahResponse>>()
    val wisataSejarah: LiveData<Result<DestinationSejarahResponse>> get() = _wisataSejarah

    private val destinationList: MutableList<DataItemAll> = mutableListOf()
    fun getDestinationAll() {
        _all.value = Result.Loading
        viewModelScope.launch {
            _all.value = getDestinationAllUseCase.getDestinationAll().last()

        }
    }
    fun getDestinationAlam() {
        _wisataAlam.value = Result.Loading
        viewModelScope.launch {
            _wisataAlam.value = getDestinationAlamUseCase.getDestinationAlam().last()

        }
    }

    fun getDestinationPendidikan() {
        _wisataPendidikan.value = Result.Loading
        viewModelScope.launch {
            _wisataPendidikan.value = getDestinationPendidikanUseCase.getDestinationPendidikan().last()

        }
    }

    fun getDestinationReligi() {
        _wisataReligi.value = Result.Loading
        viewModelScope.launch {
            _wisataReligi.value = getDestinationReligiUseCase.getDestinationReligi().last()

        }
    }
    fun getDestinationSejarah() {
        _wisataSejarah.value = Result.Loading
        viewModelScope.launch {
            _wisataSejarah.value = getDestinationSejarahUseCase.getDestinationSejarah().last()

        }
    }
    fun searchDestinations(query: String): List<DataItemAll> {
        val filteredList: MutableList<DataItemAll> = mutableListOf()
        for (destination in destinationList) {
            if (destination.name?.contains(query, ignoreCase = true) == true) {
                filteredList.add(destination)
            }
        }
        return filteredList
    }
 }