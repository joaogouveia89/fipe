package io.github.joaogouveia89.fipe.room.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    foreignKeys = [ForeignKey(
        entity = BrandModel::class,
        parentColumns = ["id"],
        childColumns = ["brandModelId"],
        onDelete = ForeignKey.CASCADE
    )]
)
data class ModelYear(
    @PrimaryKey val id: String,
    @ColumnInfo(name = "brandModelId") val brandModelId: String,
    @ColumnInfo(name = "year") val name: String?
)