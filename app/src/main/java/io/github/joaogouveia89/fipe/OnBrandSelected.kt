package io.github.joaogouveia89.fipe

import io.github.joaogouveia89.fipe.network.Brand

interface OnBrandSelected {
    fun onSelected(brand: Brand)
}