package io.github.joaogouveia89.fipe.room

const val DATABASE_NAME = "fipe-db"

const val GET_BRANDS_GET_ALL = "SELECT * FROM Brand"

const val GET_BRAND_MODELS_ALL = "SELECT * FROM BrandModel WHERE brandId = :brandId"

const val GET_MODEL_YEARS_GET_ALL = "SELECT * FROM ModelYear WHERE brandModelId = :brandModelId"

const val GET_CAR_DETAILS = "SELECT * FROM Car WHERE modelYearId = :modelYearId AND brandModelId = :brandModelId AND brandId = :brandId"
