package io.github.joaogouveia89.fipe.brands

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import io.github.joaogouveia89.fipe.R

class BrandViewHolder(val view: View): RecyclerView.ViewHolder(view) {
    val brandName = view.findViewById<TextView>(R.id.brand_name)
}