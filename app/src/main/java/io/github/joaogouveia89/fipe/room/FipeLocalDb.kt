package io.github.joaogouveia89.fipe.room

import androidx.room.Database
import androidx.room.RoomDatabase
import io.github.joaogouveia89.fipe.room.daos.BrandModelDao
import io.github.joaogouveia89.fipe.room.daos.BrandsDao
import io.github.joaogouveia89.fipe.room.daos.CarDao
import io.github.joaogouveia89.fipe.room.daos.ModelYearDao
import io.github.joaogouveia89.fipe.room.entities.Brand
import io.github.joaogouveia89.fipe.room.entities.BrandModel
import io.github.joaogouveia89.fipe.room.entities.Car
import io.github.joaogouveia89.fipe.room.entities.ModelYear

@Database(entities = [
            Brand::class,
            BrandModel::class,
            ModelYear::class,
            Car::class
        ], version = 1)
abstract class FipeLocalDb : RoomDatabase() {
    abstract fun brandsDao(): BrandsDao
    abstract fun brandModelsDao(): BrandModelDao

    abstract fun modelYearDao(): ModelYearDao

    abstract fun carDao(): CarDao
}

/*
object instantiation example and usage

val db = Room.databaseBuilder(
        applicationContext,
        FipeLocalDb::class.java, DATABASE_NAME
    ).build()

val userDao = db.userDao()
val users: List<User> = userDao.getAll()
 */