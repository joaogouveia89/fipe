package io.github.joaogouveia89.fipe.room.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Brand(
    @PrimaryKey val id: String,
    @ColumnInfo(name = "name") val name: String?
)
