package com.example.task_1

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class Users(
    @PrimaryKey(autoGenerate = true)
    val id : Int,
    val name : String,
    val email : String,
    val gender : String,
    val stream : String,
    val emp_type : String,
)
