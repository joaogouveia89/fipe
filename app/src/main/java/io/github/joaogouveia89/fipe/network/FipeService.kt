package io.github.joaogouveia89.fipe.network

import io.github.joaogouveia89.fipe.network.models.BrandModels
import io.github.joaogouveia89.fipe.network.models.FipeResult
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface FipeService {
    @GET("carros/marcas")
    fun fetchBrands(): Call<List<FipeResult?>?>?

    @GET("carros/marcas/{brandId}/modelos")
    fun fetchBrandModels(@Path("brandId") brandId: Int): Call<BrandModels?>?

    @GET("carros/marcas/{brandId}/modelos/{modelId}/anos")
    fun fetchBrandModelYears(@Path("brandId") brandId: Int, @Path("modelId") modelId: String): Call<List<FipeResult?>?>?
}
