package io.github.joaogouveia89.fipe.network.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class ModelDetails(
    @SerializedName("TipoVeiculo") val vehicleType: Int,
    @SerializedName("Valor") val value: String,
    @SerializedName("Marca") val brand: String,
    @SerializedName("Modelo") val model: String,
    @SerializedName("AnoModelo") val year: String,
    @SerializedName("Combustivel") val fuel: String,
    @SerializedName("CodigoFipe") val fipeCode: String,
    @SerializedName("MesReferencia") val referenceMonth: String,
) : Parcelable
