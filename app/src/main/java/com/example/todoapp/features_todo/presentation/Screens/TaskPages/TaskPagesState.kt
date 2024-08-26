package com.example.todoapp.features_todo.presentation.Screens.TaskPages

import com.example.todoapp.features_todo.Domain.model.Todo
import com.example.todoapp.features_todo.Domain.model.TodoItem
import com.example.todoapp.features_todo.Domain.util.OrderType
import com.example.todoapp.features_todo.Domain.util.TodoOrder

data class TaskPagesState(
    val todos: List<Todo> = emptyList(),
    val todosItem: List<TodoItem> = emptyList(),
    val todoOrder: TodoOrder = TodoOrder.Date(OrderType.Descending),
    var isOrderSectionVisible: Boolean = false
)
