package com.example.todoapp.features_todo.Data.repository

import com.example.todoapp.features_todo.Domain.model.Item
import com.example.todoapp.features_todo.Domain.model.Todo
import com.example.todoapp.features_todo.Data.data_source.TodoDao
import com.example.todoapp.features_todo.Domain.repository.TodoRepositary
import kotlinx.coroutines.flow.Flow

class TodoRepositoryImplementation(
    private val dao : TodoDao
) : TodoRepositary {
    override suspend fun insertTodo(todo: Todo) {
        dao.insertTodo(todo)
    }

    override suspend fun insertItem(item: Item) {
        dao.insertItem(item)
    }

    override suspend fun deleteTodo(todo: Todo) {
        dao.deleteTodo(todo)
    }

    override suspend fun deleteItem(item: Item) {
        dao.deleteItem(item)
    }

    override fun getAllTodos(): Flow<List<Todo>> {
        return dao.getAllTodos()
    }

    override suspend fun getTodoById(id: Int): Todo? {
        return dao.getTodoById(id)
    }

    override fun getItemsByTodoId(todoId: Int): Flow<List<Item>> {
        TODO("Not yet implemented")
    }
}