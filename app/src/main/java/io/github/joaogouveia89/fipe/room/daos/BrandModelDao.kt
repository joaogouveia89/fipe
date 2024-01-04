package io.github.joaogouveia89.fipe.room.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import io.github.joaogouveia89.fipe.room.GET_BRAND_MODELS_ALL
import io.github.joaogouveia89.fipe.room.entities.BrandModel

@Dao
interface BrandModelDao {
    @Query(GET_BRAND_MODELS_ALL)
    fun getBrandModelsByBrandId(brandId: String): List<BrandModel>

    @Insert
    fun insertBrandModel(brandModel: BrandModel)
}