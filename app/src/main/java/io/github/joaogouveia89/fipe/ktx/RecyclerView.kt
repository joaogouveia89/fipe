package io.github.joaogouveia89.fipe.ktx

import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

fun RecyclerView.addVerticalDivider(){
    addItemDecoration(
        DividerItemDecoration(
            context,
            LinearLayoutManager.VERTICAL
        )
    )
}