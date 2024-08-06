package com.example.todoapp.features_todo.presentation.Todo

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todoapp.features_todo.Domain.model.Todo
import com.example.todoapp.features_todo.Domain.use_case.TodoUsecases
import com.example.todoapp.features_todo.Domain.util.OrderType
import com.example.todoapp.features_todo.Domain.util.TodoOrder
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TodoViewModel @Inject constructor(
    private val todoUsecases: TodoUsecases
): ViewModel() {

    private val _state = mutableStateOf(TodosState())
    val state: State<TodosState> = _state

    private var recentlyDeletedTodo: Todo? = null

    private var getTodosJob: Job? = null

    init {
        getTodos(TodoOrder.Priority(OrderType.Descending))
    }

    fun onEvent(event: TodoEvents){
        when(event){
            is TodoEvents.Order -> {
                if(
                    state.value.todoOrder::class == event.todoOrder::class &&
                    state.value.todoOrder.orderType == event.todoOrder.orderType
                    ){
                    return
                }
            }
            is TodoEvents.DeleteTodo -> {
                viewModelScope.launch {
                    todoUsecases.deleteTodoUsecase(event.todo)
                    recentlyDeletedTodo =event.todo
                }
            }
            TodoEvents.RestoreTodo -> {
                viewModelScope.launch {
                    todoUsecases.addTodoUsecase(recentlyDeletedTodo?: return@launch)
                    recentlyDeletedTodo = null
                }
            }
            TodoEvents.ToggleOrderSection -> {
                _state.value = _state.value.copy(
                    isOrderSectionVisible = !state.value.isOrderSectionVisible
                )
            }
        }
    }

    private fun getTodos(todoOrder: TodoOrder){
        getTodosJob?.cancel()
        getTodosJob = todoUsecases.getTodoUsecase(todoOrder)
            .onEach {
                _state.value = state.value.copy(
                    todos = it,
                    todoOrder = todoOrder
                )
            }.launchIn(viewModelScope)

    }

}