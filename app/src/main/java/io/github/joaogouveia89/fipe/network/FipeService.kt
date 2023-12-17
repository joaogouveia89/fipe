package io.github.joaogouveia89.fipe.network

import retrofit2.Call
import retrofit2.http.GET

interface FipeService {
    @GET("carros/marcas")
    fun fetchBrands(): Call<List<Brand?>?>?
}
