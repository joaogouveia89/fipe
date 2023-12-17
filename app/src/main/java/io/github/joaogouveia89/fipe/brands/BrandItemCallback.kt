package io.github.joaogouveia89.fipe.brands

import androidx.recyclerview.widget.DiffUtil
import io.github.joaogouveia89.fipe.network.Brand

object BrandItemCallback: DiffUtil.ItemCallback<Brand>() {
    override fun areItemsTheSame(oldItem: Brand, newItem: Brand): Boolean = oldItem.code == newItem.code

    override fun areContentsTheSame(oldItem: Brand, newItem: Brand): Boolean = oldItem.name == newItem.name
}