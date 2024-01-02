package io.github.joaogouveia89.fipe

import android.os.Bundle
import androidx.fragment.app.Fragment
import io.github.joaogouveia89.fipe.network.FipeApi
import javax.inject.Inject

open class FipeFragment : Fragment() {

    @Inject
    lateinit var fipeApi: FipeApi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (requireActivity().application as FipeApplication).fipeComponent.inject(this)
    }
}