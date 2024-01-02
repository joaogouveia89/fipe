package io.github.joaogouveia89.fipe.di

import dagger.Module
import dagger.Provides
import io.github.joaogouveia89.fipe.network.FipeApi
import io.github.joaogouveia89.fipe.network.FipeService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {
    @Singleton
    @Provides
    fun provideFipeApi(): FipeApi = FipeApi()
}