package io.github.joaogouveia89.fipe.fiperesult

import androidx.recyclerview.widget.DiffUtil
import io.github.joaogouveia89.fipe.network.models.FipeResult

object FipeResultItemCallback: DiffUtil.ItemCallback<FipeResult>() {
    override fun areItemsTheSame(oldItem: FipeResult, newItem: FipeResult): Boolean = oldItem.code == newItem.code

    override fun areContentsTheSame(oldItem: FipeResult, newItem: FipeResult): Boolean = oldItem.name == newItem.name
}