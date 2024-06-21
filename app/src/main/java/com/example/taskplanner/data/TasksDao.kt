package com.example.taskplanner.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface TasksDao {
    @Insert
    suspend fun insert(task: Tasks)
    @Delete
    suspend fun delete(task: Tasks)

    @Query("SELECT * FROM tasks")
    fun getAll(): Flow<List<Tasks>>
}