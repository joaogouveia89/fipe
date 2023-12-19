package io.github.joaogouveia89.fipe.network.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class FipeResult(
    @SerializedName("codigo") val code: String,
    @SerializedName("nome") val name: String
) : Parcelable
