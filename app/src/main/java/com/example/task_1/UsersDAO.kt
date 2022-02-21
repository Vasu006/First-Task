package com.example.task_1

import androidx.room.*

@Dao
interface UsersDAO {
    @Insert
    suspend fun insertUser(users: Users)

    @Update
    suspend fun updateUser(users: Users)

    @Delete
    suspend fun deleteUser(users: Users)

    @Query("SELECT * FROM users ORDER BY name ASC")
    fun getUsers(): List<Users>

    @Query("DELETE FROM users")
    fun deleteEntries()
}