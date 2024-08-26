package com.example.todoapp.features_todo.presentation.Screens.TaskPages

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todoapp.features_todo.Domain.use_case.TodoUsecases.TodoUsecases
import com.example.todoapp.features_todo.Domain.util.OrderType
import com.example.todoapp.features_todo.Domain.util.TodoOrder
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TaskPagesViewModel @Inject constructor(
    private val todoUsecases: TodoUsecases
): ViewModel() {

    private val _state = mutableStateOf(TaskPagesState())
    val state: State<TaskPagesState> = _state


    private var getTodosJob: Job? = null

//    init {
//        getTodos(TodoOrder.Priority(OrderType.Descending))
//    }

    fun onEvent(event: TaskPagesEvents){
//        when(event){
//            is TaskPagesEvents.Order -> {
//                if(
//                    state.value.todoOrder::class == event.todoOrder::class &&
//                    state.value.todoOrder.orderType == event.todoOrder.orderType
//                    ){
//                    return
//                }
//            }
//            is TaskPagesEvents.DeleteTaskPages -> {
//                viewModelScope.launch {
//                    todoUsecases.deleteTodo(event.todo)
//                }
//            }
//            TaskPagesEvents.ToggleOrderSection -> {
//                _state.value = _state.value.copy(
//                    isOrderSectionVisible = !state.value.isOrderSectionVisible
//                )
//            }
//        }
    }

//    private fun getTodos(todoOrder: TodoOrder){
//        getTodosJob?.cancel()
//        getTodosJob = todoUsecases.getTodosUsecase(todoOrder)
//            .onEach {
//                _state.value = state.value.copy(
//                    todos = it,
//                    todoOrder = todoOrder
//                )
//            }.launchIn(viewModelScope)
//
//    }

}