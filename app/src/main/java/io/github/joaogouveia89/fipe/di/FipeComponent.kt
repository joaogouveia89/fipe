package io.github.joaogouveia89.fipe.di

import dagger.Component
import io.github.joaogouveia89.fipe.FipeFragment
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class])
interface FipeComponent {
    fun inject(fragment: FipeFragment)
}