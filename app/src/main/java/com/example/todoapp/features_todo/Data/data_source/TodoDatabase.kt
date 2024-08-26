package com.example.todoapp.features_todo.Data.data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.todoapp.features_todo.Domain.model.Todo
import com.example.todoapp.features_todo.Domain.model.TodoItem

@Database(entities = [Todo::class, TodoItem::class], version = 1)
abstract class TodoDatabase : RoomDatabase() {
    abstract val todoDao: TodoDao

    companion object {
        const val DATABASE_NAME = "todo_db"
    }
}