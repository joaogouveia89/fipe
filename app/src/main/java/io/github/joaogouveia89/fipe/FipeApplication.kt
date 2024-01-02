package io.github.joaogouveia89.fipe

import android.app.Application
import io.github.joaogouveia89.fipe.di.DaggerFipeComponent
import io.github.joaogouveia89.fipe.di.FipeComponent
import io.github.joaogouveia89.fipe.di.NetworkModule
import io.github.joaogouveia89.fipe.network.FipeApi

class FipeApplication: Application() {
    val fipeComponent: FipeComponent by lazy {
        DaggerFipeComponent.builder()
            .networkModule(NetworkModule())
            .build()
    }

}