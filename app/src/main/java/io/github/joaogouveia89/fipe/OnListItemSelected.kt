package io.github.joaogouveia89.fipe

import io.github.joaogouveia89.fipe.network.models.FipeResult

interface OnListItemSelected {
    fun onSelected(item: FipeResult)
}