package io.github.joaogouveia89.fipe.fiperesult

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import io.github.joaogouveia89.fipe.R

class FipeResultViewHolder(val view: View): RecyclerView.ViewHolder(view) {
    val name = view.findViewById<TextView>(R.id.name)
}