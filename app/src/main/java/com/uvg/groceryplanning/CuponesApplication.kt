package com.uvg.groceryplanning

import android.app.Application
import com.uvg.groceryplanning.database.AppDatabase

class CuponesApplication : Application() {
    val database: AppDatabase by lazy { AppDatabase.getDatabase(this) }
}