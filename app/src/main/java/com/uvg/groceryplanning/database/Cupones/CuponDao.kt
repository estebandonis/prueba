package com.uvg.groceryplanning.database.Cupones

import androidx.room.Dao
import androidx.room.Query

@Dao
interface CuponDao {

    @Query("SELECT * FROM Cupon")
    fun getAll(): List<Cupon>
}