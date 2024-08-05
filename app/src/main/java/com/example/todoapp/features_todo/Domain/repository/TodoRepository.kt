package com.example.todoapp.features_todo.Domain.repository

import com.example.todoapp.features_todo.Domain.model.Item
import com.example.todoapp.features_todo.Domain.model.Todo
import kotlinx.coroutines.flow.Flow

interface TodoRepository {

    suspend fun insertTodo(todo: Todo)

    suspend fun insertItem(item: Item)

    suspend fun deleteTodo(todo: Todo)

    suspend fun deleteItem(item: Item)

    fun getAllTodos(): Flow<List<Todo>>

    suspend fun getTodoById(id: Int): Todo?

    fun getItemsByTodoId(todoId: Int): Flow<List<Item>>
}