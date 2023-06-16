package com.bangkit.tursik.di

import com.bangkit.tursik.domain.usecase.getdestinationalam.GetDestinationAlamInteractor
import com.bangkit.tursik.domain.usecase.getdestinationalam.GetDestinationAlamUseCase
import com.bangkit.tursik.domain.usecase.getdestinationall.GetDestinationAllInteractor
import com.bangkit.tursik.domain.usecase.getdestinationall.GetDestinationAllUseCase
import com.bangkit.tursik.domain.usecase.getdestinationpendidikan.GetDestinationPendidikanInteractor
import com.bangkit.tursik.domain.usecase.getdestinationpendidikan.GetDestinationPendidikanUseCase
import com.bangkit.tursik.domain.usecase.getdestinationpopular.GetDestinationPopularUseCase
import com.bangkit.tursik.domain.usecase.getdestinationpopular.GetDestinationPopulerInteractor
import com.bangkit.tursik.domain.usecase.getdestinationrecomend.GetDestinationRecomendedInteractor
import com.bangkit.tursik.domain.usecase.getdestinationrecomend.GetDestinationRecomendedUseCase
import com.bangkit.tursik.domain.usecase.getdestinationreligi.GetDestinationReligiInteractor
import com.bangkit.tursik.domain.usecase.getdestinationreligi.GetDestinationReligiUseCase
import com.bangkit.tursik.domain.usecase.getdestinationsejarah.GetDestinationSejarahInteractor
import com.bangkit.tursik.domain.usecase.getdestinationsejarah.GetDestinationSejarahUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface UseCaseModule {

    @Binds
    fun bindGetPlaceListUseCase(interactor: GetDestinationPopulerInteractor):
            GetDestinationPopularUseCase

    @Binds
    fun bindGetPlaceListRecomendedUseCase(interactor: GetDestinationRecomendedInteractor):
            GetDestinationRecomendedUseCase

    @Binds
    fun bindGetPlaceListAllUseCase(interactor: GetDestinationAllInteractor):
            GetDestinationAllUseCase

    @Binds
    fun bindGetPlaceListAlamUseCase(interactor: GetDestinationAlamInteractor):
            GetDestinationAlamUseCase

    @Binds
    fun bindGetPlaceListPendidikanUseCase(interactor: GetDestinationPendidikanInteractor):
            GetDestinationPendidikanUseCase

    @Binds
    fun bindGetPlaceListReligiUseCase(interactor: GetDestinationReligiInteractor):
            GetDestinationReligiUseCase

    @Binds
    fun bindGetPlaceListSejarahUseCase(interactor: GetDestinationSejarahInteractor):
            GetDestinationSejarahUseCase
}