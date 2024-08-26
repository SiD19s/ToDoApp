package com.example.todoapp.features_todo.presentation.Screens.TaskPages

import com.example.todoapp.features_todo.Domain.model.Todo
import com.example.todoapp.features_todo.Domain.util.TodoOrder

sealed class TaskPagesEvents {
    data class Order(val todoOrder: TodoOrder): TaskPagesEvents()
    data class DeleteTaskPages(val todo: Todo): TaskPagesEvents()
    object ToggleOrderSection: TaskPagesEvents()
}