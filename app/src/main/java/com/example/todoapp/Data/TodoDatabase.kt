package com.example.todoapp.Data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Todo::class, Item::class], version = 1)
abstract class TodoDatabase : RoomDatabase() {
    abstract fun todoDao(): TodoDao
}