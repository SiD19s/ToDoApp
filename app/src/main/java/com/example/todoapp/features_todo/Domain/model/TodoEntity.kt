package com.example.todoapp.features_todo.Domain.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "todos")
data class Todo(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val title: String,
    val notes:String?,
    val timestamp:Long,
    val priority: String,
){
    companion object{
        val notePriority = listOf("HighPriority","MidPriority","LowPriority")
    }
}

@Entity(
    tableName = "items",
    foreignKeys = [ForeignKey(
        entity = Todo::class,
        parentColumns = ["id"],
        childColumns = ["todoId"])]
)
data class Item(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val todoId: Long, // Foreign key referencing the Todo entity
    val title: String,
    val isChecked: Boolean
)

class InvalidTodoException(message: String):Exception(message)