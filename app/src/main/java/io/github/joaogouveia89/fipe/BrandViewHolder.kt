package io.github.joaogouveia89.fipe

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class BrandViewHolder(val view: View): ViewHolder(view) {
    val brandName = view.findViewById<TextView>(R.id.brand_name)
}