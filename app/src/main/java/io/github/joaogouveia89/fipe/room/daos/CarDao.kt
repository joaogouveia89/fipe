package io.github.joaogouveia89.fipe.room.daos

import androidx.room.ColumnInfo
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.PrimaryKey
import androidx.room.Query
import io.github.joaogouveia89.fipe.room.GET_CAR_DETAILS
import io.github.joaogouveia89.fipe.room.entities.Car

@Dao
interface CarDao {
    @Query(GET_CAR_DETAILS)
    fun getCarDetails(
        modelYearId: String,
        brandModelId: String,
        brandId: String
    ): Car

    @Insert
    fun insertCarDetails(car: Car)
}