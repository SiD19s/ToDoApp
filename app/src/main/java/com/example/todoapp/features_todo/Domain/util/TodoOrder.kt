package com.example.todoapp.features_todo.Domain.util

sealed class TodoOrder(val orderType: OrderType) {
    class Title(orderType: OrderType): TodoOrder(orderType)
    class Date(orderType: OrderType): TodoOrder(orderType)
    class Priority(orderType: OrderType): TodoOrder(orderType)

    fun copy(orderType: OrderType):TodoOrder{
        return when(this){
            is Title -> Title(orderType)
            is Date -> Date(orderType)
            is Priority -> Priority(orderType)
        }
    }

}