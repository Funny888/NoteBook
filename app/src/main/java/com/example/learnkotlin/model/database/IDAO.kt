package com.example.learnkotlin.model.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface IDAO {

    @Query("SELECT * FROM person")
    suspend fun readAllData(): MutableList<PersonTable>

    @Query("SELECT * FROM person WHERE Name LIKE '%' || :value || '%' OR Family LIKE '%' || :value || '%' OR Number LIKE '%' || :value || '%'")
    suspend fun queryFilter(value: String): MutableList<PersonTable>

    @Insert
    suspend fun insertData(newPerson: PersonTable)

    @Delete
    suspend fun deleteData(newPerson: PersonTable)

    @Query("DELETE FROM person")
    suspend fun deleteAllData()
}