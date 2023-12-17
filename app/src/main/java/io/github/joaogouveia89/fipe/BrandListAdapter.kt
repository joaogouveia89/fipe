package io.github.joaogouveia89.fipe

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import io.github.joaogouveia89.fipe.network.Brand

class BrandListAdapter: ListAdapter<Brand, BrandViewHolder>(BrandItemCallback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BrandViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.brand_list_item, parent, false)
        return BrandViewHolder(view)
    }

    override fun onBindViewHolder(holder: BrandViewHolder, position: Int) {
        holder.brandName.text = currentList[position].name
    }

}