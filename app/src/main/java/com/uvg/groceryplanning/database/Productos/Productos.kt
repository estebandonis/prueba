package com.uvg.groceryplanning.database.Productos

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Productos (
    @PrimaryKey @ColumnInfo(name = "Id") val id: Int,
    @NonNull @ColumnInfo(name = "Nombre") val oferta: String,
    @NonNull @ColumnInfo(name = "Producto") val producto: String,
    @NonNull @ColumnInfo(name = "Supermercado") val supermercado: String
)