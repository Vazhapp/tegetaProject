package ge.vazhapp.myapplication.data.repository

import ge.vazhapp.myapplication.common.Resource
import ge.vazhapp.myapplication.data.model.Colors
import ge.vazhapp.myapplication.data.model.ColorsItem
import ge.vazhapp.myapplication.data.remote.ColorsApiService
import ge.vazhapp.myapplication.domain.repository.ColorsRepo
import javax.inject.Inject

class ColorsRepoImpl @Inject constructor(
    private val colorsApiService: ColorsApiService
) : ColorsRepo {
    override suspend fun getColors(): Resource<List<ColorsItem>> {
       return Resource.Success(data = colorsApiService.getColors().body())
    }
}