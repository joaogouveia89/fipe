package io.github.joaogouveia89.fipe.network

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Brand(
    @SerializedName("codigo") val code: Int,
    @SerializedName("nome") val name: String
): Parcelable
