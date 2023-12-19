package io.github.joaogouveia89.fipe.ktx

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

fun Fragment.setTitle(title: String) {
    (requireActivity() as AppCompatActivity).supportActionBar?.title = title
}