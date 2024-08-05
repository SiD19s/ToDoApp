package com.example.todoapp.features_todo.Domain.use_case

import com.example.todoapp.features_todo.Domain.model.Todo
import com.example.todoapp.features_todo.Domain.repository.TodoRepository

class DeleteTodoUsecase(
    private val repositary: TodoRepository
) {
    suspend operator fun invoke(todo: Todo){
        repositary.deleteTodo(todo)
    }
}