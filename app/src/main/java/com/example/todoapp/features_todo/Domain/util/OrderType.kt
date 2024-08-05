package com.example.todoapp.features_todo.Domain.util

sealed class OrderType {
    object Ascending: OrderType()
    object Descending: OrderType()
}