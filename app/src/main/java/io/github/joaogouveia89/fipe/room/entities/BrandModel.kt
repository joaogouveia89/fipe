package io.github.joaogouveia89.fipe.room.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    foreignKeys = [ForeignKey(
        entity = Brand::class,
        parentColumns = ["id"],
        childColumns = ["brandId"],
        onDelete = ForeignKey.CASCADE
    )]
)
data class BrandModel(
    @PrimaryKey val id: String,
    @ColumnInfo(name = "brandId") val brandId: String,
    @ColumnInfo(name = "name") val name: String?
)