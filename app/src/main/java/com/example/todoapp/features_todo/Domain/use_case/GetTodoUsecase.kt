package com.example.todoapp.features_todo.Domain.use_case

import com.example.todoapp.features_todo.Domain.model.Todo
import com.example.todoapp.features_todo.Domain.repository.TodoRepository
import com.example.todoapp.features_todo.Domain.util.OrderType
import com.example.todoapp.features_todo.Domain.util.TodoOrder
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetTodoUsecase(
    private val repositary: TodoRepository
) {


    suspend operator fun invoke(
        todoOrder: TodoOrder = TodoOrder.Priority(OrderType.Descending)
    ) : Flow<List<Todo>> {
        return repositary.getAllTodos().map {  todos ->
            when(todoOrder.orderType){
                is OrderType.Ascending ->{
                    when(todoOrder){
                        is TodoOrder.Title -> todos.sortedBy { it.title.lowercase() }
                        is TodoOrder.Date -> todos.sortedBy { it.timestamp }
                        is TodoOrder.Priority -> todos.sortedBy { it.priority }
                    }
                }

                is OrderType.Descending -> {
                    when (todoOrder) {
                        is TodoOrder.Title -> todos.sortedByDescending { it.title.lowercase() }
                        is TodoOrder.Date -> todos.sortedByDescending { it.timestamp }
                        is TodoOrder.Priority -> todos.sortedByDescending { it.priority }

                    }
                }
            }
        }

    }
}