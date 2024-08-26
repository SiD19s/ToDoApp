package com.example.todoapp.features_todo.presentation.Navigation

sealed class Screen(val route: String) {
    object TodoList : Screen("todo_list")
    object TodoDetail : Screen("todo_detail/{todoId}") {
        fun createRoute(todoId: Long) = "todo_detail/$todoId"
    }
}