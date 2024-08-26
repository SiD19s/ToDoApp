package com.example.todoapp.features_todo.Data.repository

import com.example.todoapp.features_todo.Domain.model.Todo
import com.example.todoapp.features_todo.Data.data_source.TodoDao
import com.example.todoapp.features_todo.Data.data_source.TodoWithItems
import com.example.todoapp.features_todo.Domain.model.TodoItem
import com.example.todoapp.features_todo.Domain.repository.TodoRepository
import kotlinx.coroutines.flow.Flow

class TodoRepositoryImplementation(
    private val todoDao: TodoDao
) : TodoRepository {

    override fun getAllTodosWithItems(): Flow<List<TodoWithItems>> {
        return todoDao.getAllTodosWithItems()
    }

    override suspend fun getTodoWithItems(todoId: Long): TodoWithItems? {
        return todoDao.getTodoWithItems(todoId)
    }

    override suspend fun insertTodoAndItems(todo: Todo, items: List<TodoItem>) {
        todoDao.insertTodoAndItems(todo, items)
    }

    override suspend fun deleteTodoAndItems(todo: Todo) {
        todoDao.deleteTodoAndItems(todo)
    }

    override suspend fun insertTodoItem(todoItem: TodoItem) {
        todoDao.insertTodoItem(todoItem)
    }

    override suspend fun deleteTodoItem(itemId: Long) {
        todoDao.deleteTodoItem(itemId)
    }


}