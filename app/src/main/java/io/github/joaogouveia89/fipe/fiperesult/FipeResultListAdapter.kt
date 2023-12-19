package io.github.joaogouveia89.fipe.fiperesult

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import io.github.joaogouveia89.fipe.OnListItemSelected
import io.github.joaogouveia89.fipe.R
import io.github.joaogouveia89.fipe.network.models.FipeResult

class FipeResultListAdapter(private val onItemSelected: OnListItemSelected) :
    ListAdapter<FipeResult, FipeResultViewHolder>(
        FipeResultItemCallback
    ) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FipeResultViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.string_list_item, parent, false)
        return FipeResultViewHolder(view)
    }

    override fun onBindViewHolder(holder: FipeResultViewHolder, position: Int) {
        holder.name.text = currentList[position].name
        holder.view.setOnClickListener {
            onItemSelected.onSelected(currentList[position])
        }
    }

}