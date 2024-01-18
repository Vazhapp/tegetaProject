package ge.vazhapp.myapplication.data.remote

import ge.vazhapp.myapplication.data.model.Colors
import ge.vazhapp.myapplication.data.model.ColorsItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ColorsApiService {

    @GET("/api/colors/new?format=json")
    suspend fun getColors(): Response<List<ColorsItem>>

}