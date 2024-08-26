package com.example.todoapp.features_todo.Domain.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "todos")
data class Todo(
    @PrimaryKey(autoGenerate = true)
    val id: Long?,
    val title: String,
    val description: String?,
    val timestamp: Long,
    val priority: Int
){
    companion object{
        val TodoPriority = listOf(1,2,3)
    }
}

@Entity(
    tableName = "todo_items",
    foreignKeys = [ForeignKey(
        entity = Todo::class,
        parentColumns = ["id"],
        childColumns = ["todoId"],
        onDelete = ForeignKey.CASCADE
    )]
)
data class TodoItem(
    @PrimaryKey(autoGenerate = true) val itemId: Long? = null,
    val todoId: Long?,
    val title: String,
    val isChecked: Boolean
)

class InvalidTodoException(message: String):Exception(message)