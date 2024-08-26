package com.example.todoapp.features_todo.presentation.Screens.AddEditTaskPage

import androidx.compose.ui.focus.FocusState

sealed class AddEditTodoEvent {
    data class EnteredTitle(val value: String): AddEditTodoEvent()
    data class ChangeTitleFocus(val focusState: FocusState): AddEditTodoEvent()
    data class EnteredDescription(val value: String): AddEditTodoEvent()
    data class ChangeDescription(val focusState: FocusState): AddEditTodoEvent()
    data class EnteredItemText(val value: String): AddEditTodoEvent()
    data class ChangeItemText(val todoItemId: Long, val isChecked: Boolean): AddEditTodoEvent()
    object SaveNote: AddEditTodoEvent()
}