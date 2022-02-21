package com.example.task_1

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Users::class], version = 1)
abstract class UsersDatabase : RoomDatabase() {
    abstract fun usersDAO(): UsersDAO
}