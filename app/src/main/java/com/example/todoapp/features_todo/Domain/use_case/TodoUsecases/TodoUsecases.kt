package com.example.todoapp.features_todo.Domain.use_case.TodoUsecases

import com.example.todoapp.features_todo.Data.data_source.TodoWithItems
import com.example.todoapp.features_todo.Domain.model.Todo
import com.example.todoapp.features_todo.Domain.model.TodoItem
import com.example.todoapp.features_todo.Domain.repository.TodoRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

data class TodoUsecases(
    val getAllTodosWithItems: GetAllTodosWithItems,
    val getTodoWithItems : GetTodoWithItems,
    val insertTodoAndItems : InsertTodoAndItems,
    val deleteTodoAndItems : DeleteTodoAndItems,
    val insertTodoItem : InsertTodoItem,
    val deleteTodoItem : DeleteTodoItem,
)

class GetAllTodosWithItems(
    private val repository: TodoRepository
) {
    operator fun invoke(): Flow<List<TodoWithItems>> {
        return repository.getAllTodosWithItems()
    }
}

class GetTodoWithItems @Inject constructor(
    private val repository: TodoRepository
) {
    suspend operator fun invoke(todoId: Long): TodoWithItems? {
        return repository.getTodoWithItems(todoId)
    }
}

class InsertTodoAndItems @Inject constructor(
    private val repository: TodoRepository
) {
    suspend operator fun invoke(todo: Todo, items: List<TodoItem>) {
        repository.insertTodoAndItems(todo, items)
    }
}

class DeleteTodoAndItems @Inject constructor(
    private val repository: TodoRepository
) {
    suspend operator fun invoke(todo: Todo) {
        repository.deleteTodoAndItems(todo)
    }
}

class InsertTodoItem(private val repository: TodoRepository) {
    suspend operator fun invoke(todoItem: TodoItem) {
        repository.insertTodoItem(todoItem)
    }
}

class DeleteTodoItem(private val repository: TodoRepository) {
    suspend operator fun invoke(itemId: Long) {
        repository.deleteTodoItem(itemId)
    }
}