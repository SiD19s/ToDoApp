package com.example.todoapp.features_todo.presentation.Screens

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todoapp.features_todo.Data.data_source.TodoWithItems
import com.example.todoapp.features_todo.Domain.model.Todo
import com.example.todoapp.features_todo.Domain.model.TodoItem
import com.example.todoapp.features_todo.Domain.use_case.TodoUsecases.TodoUsecases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TodoViewModel @Inject constructor(
    private val todoUseCases: TodoUsecases,
) : ViewModel() {

    private val _todoList = MutableStateFlow<List<TodoWithItems>>(emptyList())
    val todoList: StateFlow<List<TodoWithItems>> = _todoList

    private val _todoDetail = MutableStateFlow<TodoWithItems?>(null)
    val todoDetail: StateFlow<TodoWithItems?> = _todoDetail

    fun getTodos() {
        viewModelScope.launch {
            todoUseCases.getAllTodosWithItems().collect { todos ->
                _todoList.value = todos
            }
        }
    }

    fun getTodoDetail(todoId: Long) {
        viewModelScope.launch {
            _todoDetail.value = todoUseCases.getTodoWithItems(todoId)
        }
    }

    fun insertTodoAndItems(todo: Todo, items: List<TodoItem>) {
        viewModelScope.launch {
            todoUseCases.insertTodoAndItems(todo, items)
            getTodos()  // Refresh the list
        }
    }

    fun deleteTodoAndItems(todo: Todo) {
        viewModelScope.launch {
            todoUseCases.deleteTodoAndItems(todo)
            getTodos()  // Refresh the list
        }
    }

    fun insertTodoItem(todoItem: TodoItem) {
        viewModelScope.launch {
            todoUseCases.insertTodoItem(todoItem)
            getTodos()  // Refresh the list
        }
    }

    fun deleteTodoItem(itemId: Long) {
        viewModelScope.launch {
            todoUseCases.deleteTodoItem(itemId)
            getTodos()  // Refresh the list
        }
    }
}