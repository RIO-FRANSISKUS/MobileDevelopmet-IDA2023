package com.example.pertemuanpertamaapp.data.retrofit

import com.example.pertemuanpertamaapp.data.response.Response
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("detail/{id}")
    fun getRestaurant(
        @Path("id") id: String
    ): Call<Response>
}