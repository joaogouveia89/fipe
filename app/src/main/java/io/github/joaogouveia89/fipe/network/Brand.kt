package io.github.joaogouveia89.fipe.network

import com.google.gson.annotations.SerializedName

data class Brand(
    @SerializedName("codigo") val code: Int,
    @SerializedName("nome") val name: String
)
