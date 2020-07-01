package com.example.learnkotlin.model.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Person")
data class PersonTable(
    @PrimaryKey(autoGenerate = true)
    val Id: Int? = null,
    val Name:String,
    val Family:String,
    val Number:String
) {
}