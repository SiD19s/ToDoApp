package com.example.todoapp.features_todo.Data.data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.todoapp.features_todo.Domain.model.Item
import com.example.todoapp.features_todo.Domain.model.Todo

@Database(entities = [Todo::class, Item::class], version = 1)
abstract class TodoDatabase : RoomDatabase() {
    abstract val todoDao: TodoDao

    companion object {
        const val DATABASE_NAME = "todo_db"
    }
}