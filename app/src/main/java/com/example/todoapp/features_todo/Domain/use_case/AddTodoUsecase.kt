package com.example.todoapp.features_todo.Domain.use_case

import com.example.todoapp.features_todo.Domain.model.InvalidTodoException
import com.example.todoapp.features_todo.Domain.model.Todo
import com.example.todoapp.features_todo.Domain.repository.TodoRepository


class AddTodoUsecase (
    private val repositary: TodoRepository
){
    @Throws(InvalidTodoException::class)
    suspend operator fun invoke(todo: Todo){
        if (todo.title.isBlank()){
            throw InvalidTodoException("The title of the todo can't be empty.")
        }
        repositary.insertTodo(todo)
    }
}