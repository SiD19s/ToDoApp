package com.example.todoapp.features_todo.presentation

import androidx.lifecycle.ViewModel
import com.example.todoapp.features_todo.Domain.use_case.TodoUsecases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TodoViewModel @Inject constructor(
    private val todoUsecases: TodoUsecases
): ViewModel() {


}