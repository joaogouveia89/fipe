package io.github.joaogouveia89.fipe.network


import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class FipeApi {
    val retrofit = Retrofit.Builder()
        .baseUrl("https://parallelum.com.br/fipe/api/v1/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val service: FipeService = retrofit.create(FipeService::class.java)

    fun fetchBrands() = service.fetchBrands()
}