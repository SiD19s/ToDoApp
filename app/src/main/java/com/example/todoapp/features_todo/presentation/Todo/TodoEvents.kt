package com.example.todoapp.features_todo.presentation.Todo

import com.example.todoapp.features_todo.Domain.model.Todo
import com.example.todoapp.features_todo.Domain.util.TodoOrder

sealed class TodoEvents {
    data class Order(val todoOrder: TodoOrder): TodoEvents()
    data class DeleteTodo(val todo: Todo): TodoEvents()
    object RestoreTodo: TodoEvents()
    object ToggleOrderSection: TodoEvents()
}