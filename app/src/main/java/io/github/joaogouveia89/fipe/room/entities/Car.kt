package io.github.joaogouveia89.fipe.room.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    foreignKeys = [
        ForeignKey(
            entity = Brand::class,
            parentColumns = ["id"],
            childColumns = ["brandId"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = BrandModel::class,
            parentColumns = ["id"],
            childColumns = ["brandModelId"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = ModelYear::class,
            parentColumns = ["id"],
            childColumns = ["modelYearId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class Car(
    @PrimaryKey val id: String,
    @ColumnInfo(name = "value") val value: String,
    @ColumnInfo(name = "brandId") val brandId: String,
    @ColumnInfo(name = "brandModelId") val brandModelId: String,
    @ColumnInfo(name = "modelYearId") val modelYearId: String,
    @ColumnInfo(name = "fuel") val fuel: String,
    @ColumnInfo(name = "fipeCode") val fipeCode: String,
    @ColumnInfo(name = "referenceMonth") val referenceMonth: String
)