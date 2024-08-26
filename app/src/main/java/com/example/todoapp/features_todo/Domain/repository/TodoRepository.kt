package com.example.todoapp.features_todo.Domain.repository

import com.example.todoapp.features_todo.Data.data_source.TodoWithItems
import com.example.todoapp.features_todo.Domain.model.Todo
import com.example.todoapp.features_todo.Domain.model.TodoItem
import kotlinx.coroutines.flow.Flow

interface TodoRepository {

    fun getAllTodosWithItems(): Flow<List<TodoWithItems>>
    suspend fun getTodoWithItems(todoId: Long): TodoWithItems?
    suspend fun insertTodoAndItems(todo: Todo, items: List<TodoItem>)
    suspend fun deleteTodoAndItems(todo: Todo)
    suspend fun insertTodoItem(todoItem: TodoItem)
    suspend fun deleteTodoItem(itemId: Long)

}