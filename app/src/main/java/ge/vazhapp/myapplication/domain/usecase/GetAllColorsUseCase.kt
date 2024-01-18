package ge.vazhapp.myapplication.domain.usecase

import ge.vazhapp.myapplication.common.Resource
import ge.vazhapp.myapplication.data.model.Colors
import ge.vazhapp.myapplication.data.model.ColorsItem
import ge.vazhapp.myapplication.domain.repository.ColorsRepo
import javax.inject.Inject

class GetAllColorsUseCase @Inject constructor(
    private val colorsRepo: ColorsRepo
) {

    suspend operator fun invoke(): Resource<List<ColorsItem>> {
       return colorsRepo.getColors()
    }
}