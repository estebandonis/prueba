package com.uvg.groceryplanning.database.Productos

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Producto (
    @PrimaryKey @ColumnInfo(name = "Id") val id: Int,
    @NonNull @ColumnInfo(name = "Nombre") val nombre: String,
    @NonNull @ColumnInfo(name = "tipo") val tipo: String,
    @NonNull @ColumnInfo(name = "Supermercado") val supermercado: String,
    @NonNull @ColumnInfo(name = "Descripcion") val descripcion: String,
    @NonNull @ColumnInfo(name = "link") val link: String
)