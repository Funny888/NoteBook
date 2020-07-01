package com.example.learnkotlin.model.database

class DataBaseRepository(private val idao: IDAO) {

    suspend fun fetchAllData(): MutableList<PersonTable> = idao.readAllData()

    suspend fun insertData(newPerson: PersonTable) = idao.insertData(newPerson)

    suspend fun queryFilter(value: String) = idao.queryFilter(value)

    suspend fun deletePerson(newPerson: PersonTable) = idao.deleteData(newPerson)

    suspend fun deleteAllData() = idao.deleteAllData()

}