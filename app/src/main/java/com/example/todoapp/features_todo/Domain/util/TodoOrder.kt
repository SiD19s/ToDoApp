package com.example.todoapp.features_todo.Domain.util

sealed class TodoOrder(val orderType: OrderType) {
    class Title(orderType: OrderType): TodoOrder(orderType)
    class Date(orderType: OrderType): TodoOrder(orderType)
    class Priority(orderType: OrderType): TodoOrder(orderType)
}