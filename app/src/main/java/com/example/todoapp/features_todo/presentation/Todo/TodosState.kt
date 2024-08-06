package com.example.todoapp.features_todo.presentation.Todo

import com.example.todoapp.features_todo.Domain.model.Todo
import com.example.todoapp.features_todo.Domain.util.OrderType
import com.example.todoapp.features_todo.Domain.util.TodoOrder

data class TodosState(
    val todos: List<Todo> = emptyList(),
    val todoOrder: TodoOrder = TodoOrder.Date(OrderType.Descending),
    val isOrderSectionVisible: Boolean = false
)
