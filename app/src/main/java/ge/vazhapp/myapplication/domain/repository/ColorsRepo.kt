package ge.vazhapp.myapplication.domain.repository

import ge.vazhapp.myapplication.common.Resource
import ge.vazhapp.myapplication.data.model.Colors
import ge.vazhapp.myapplication.data.model.ColorsItem

interface ColorsRepo {

    suspend fun getColors(): Resource<List<ColorsItem>>

}