package io.github.joaogouveia89.fipe.room.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.github.joaogouveia89.fipe.room.GET_BRANDS_GET_ALL
import io.github.joaogouveia89.fipe.room.entities.Brand

@Dao
interface BrandsDao {
    @Query(GET_BRANDS_GET_ALL)
    fun getAll(): List<Brand>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg brands: Brand)
}