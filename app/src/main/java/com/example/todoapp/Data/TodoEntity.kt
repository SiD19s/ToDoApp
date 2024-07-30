package com.example.todoapp.Data

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "todos")
data class Todo(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val title: String,
    val notes:String,
    val priority: Int,
)

@Entity(
    tableName = "items",
    foreignKeys = [ForeignKey(
        entity = Todo::class,
        parentColumns = ["id"],
        childColumns = ["todoId"])]
)
data class Item(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val todoId: Int, // Foreign key referencing the Todo entity
    val title: String,
    val isChecked: Boolean
)
