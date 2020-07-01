package com.example.learnkotlin.model.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(PersonTable::class), version = 1)
abstract class AbstractDataBase : RoomDatabase() {

    abstract fun getIDAO():IDAO

    companion object {
        @Volatile
        private var INSTANCE: AbstractDataBase? = null

        fun getDatabase(context: Context): AbstractDataBase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AbstractDataBase::class.java,
                    "person_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}