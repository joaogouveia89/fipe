package io.github.joaogouveia89.fipe.network.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
@Parcelize
data class BrandModels(
    @SerializedName("anos") val years: List<FipeResult>,
    @SerializedName("modelos") val models: List<FipeResult>
): Parcelable
