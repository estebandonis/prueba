package com.uvg.groceryplanning.database.Ofertas

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Oferta (
    @PrimaryKey @ColumnInfo(name = "Id") val id: Int,
    @NonNull @ColumnInfo(name = "Oferta") val oferta: String,
    @NonNull @ColumnInfo(name = "Producto") val producto: String,
    @NonNull @ColumnInfo(name = "Supermercado") val supermercado: String
)