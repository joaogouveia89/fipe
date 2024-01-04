package io.github.joaogouveia89.fipe.room.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.github.joaogouveia89.fipe.room.GET_MODEL_YEARS_GET_ALL
import io.github.joaogouveia89.fipe.room.entities.ModelYear

@Dao
interface ModelYearDao {
    @Query(GET_MODEL_YEARS_GET_ALL)
    fun getBrandModelYearsByBrandModelId(brandModelId: String): List<ModelYear>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertBrandModelYear(modelYear: ModelYear)
}