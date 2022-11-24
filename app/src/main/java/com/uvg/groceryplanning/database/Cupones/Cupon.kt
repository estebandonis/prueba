package com.uvg.groceryplanning.database.Cupones

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Cupon (
    @PrimaryKey @ColumnInfo(name = "Id") val id: Int,
    @NonNull @ColumnInfo(name = "Porcentaje") val porcentaje: String,
    @NonNull @ColumnInfo(name = "Producto") val producto: String,
    @NonNull @ColumnInfo(name = "Supermercado") val supermercado: String,
    @NonNull @ColumnInfo(name = "Disponibilidad") val disponibilidad: String
)