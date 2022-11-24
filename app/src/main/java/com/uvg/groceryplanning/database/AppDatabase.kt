package com.uvg.groceryplanning.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.uvg.groceryplanning.database.Cupones.Cupon

@Database(entities = arrayOf(Cupon::class), version = 1)
abstract class AppDatabase: RoomDatabase(){

    companion object{
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase{
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context,
                    AppDatabase::class.java,
                    "app_database")
                    .createFromAsset("databases/cupones.db")
                    .build()
                INSTANCE = instance

                instance
            }
        }
    }
}