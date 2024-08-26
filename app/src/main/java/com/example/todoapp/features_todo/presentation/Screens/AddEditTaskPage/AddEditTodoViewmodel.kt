//package com.example.todoapp.features_todo.presentation.Screens.AddEditTaskPage
//
//import androidx.compose.runtime.State
//import androidx.compose.runtime.mutableStateOf
//import androidx.lifecycle.SavedStateHandle
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.viewModelScope
//import com.example.todoapp.features_todo.Domain.model.InvalidTodoException
//import com.example.todoapp.features_todo.Domain.model.Todo
//import com.example.todoapp.features_todo.Domain.model.TodoItem
//import com.example.todoapp.features_todo.Domain.use_case.TodoUsecases.TodoUsecases
//import dagger.hilt.android.lifecycle.HiltViewModel
//import kotlinx.coroutines.flow.MutableSharedFlow
//import kotlinx.coroutines.flow.asSharedFlow
//import kotlinx.coroutines.launch
//import javax.inject.Inject
//
//@HiltViewModel
//class AddEditTodoViewmodel @Inject constructor(
//    private val todoUseCases: TodoUsecases,
//    savedStateHandle: SavedStateHandle
//): ViewModel(){
//
//    private val _todoTitle = mutableStateOf(AddEditTodoTextfieldState(hint = "Enter title..."))
//    val todoTitle: State<AddEditTodoTextfieldState> = _todoTitle
//
//    private val _todoDes = mutableStateOf(AddEditTodoTextfieldState(hint = "Enter Description..."))
//    val todoDes: State<AddEditTodoTextfieldState> = _todoDes
//
//    private val _todoItems = mutableStateOf(listOf<TodoItem>())
//    val todoItems: State<List<TodoItem>> = _todoItems
//
//    private val _todoPriority = mutableStateOf(1)
//    val todoPriority: State<Int> = _todoPriority
//
//
//
//    private val _eventFlow = MutableSharedFlow<UiEvent>()
//    val eventFlow = _eventFlow.asSharedFlow()
//
//    private var currentTodoId: Long? = null
//
//    sealed class UiEvent {
//        data class ShowSnackbar(val message: String): UiEvent()
//        object SaveNote: UiEvent()
//    }
//
//
//    init {
//        savedStateHandle.get<Long>("todoId")?.let { todoId ->
//            if (todoId != -1L) {
//                viewModelScope.launch {
//                    val todo = todoUseCases.getTodo
//                    todoUseCases.getTodo(todoId)?.also { todo ->
//                        currentTodoId = todo.id
//                        _todoTitle.value = todoTitle.value.copy(todo.title, isHintVisible = false)
//                        _todoPriority.value = todo.priority
//                    }
//                }
//            }
//        }
//    }
//
//    fun onEvent(event: AddEditTodoEvent){
//        when(event){
//            is AddEditTodoEvent.ChangeItemText ->{
//                _todoItems.value = todoItems.value.map {
//                    if (it.itemId == event.todoItemId) it.copy(isChecked = event.isChecked) else it
//                }
//            }
//            is AddEditTodoEvent.ChangeTitleFocus -> {
//                _todoTitle.value = todoTitle.value.copy(
//                    isHintVisible = !event.focusState.isFocused
//                        && todoTitle.value.text.isBlank()
//                )
//            }
//            is AddEditTodoEvent.EnteredItemText -> {
//                _todoItems.value = todoItems.value.toMutableList().apply {
//                    add(TodoItem(todoId = currentTodoId, isChecked = false, title = event.value))
//                }
//            }
//            is AddEditTodoEvent.EnteredTitle -> {
//                _todoTitle.value = todoTitle.value.copy(event.value)
//            }
//            AddEditTodoEvent.SaveNote -> {
//                viewModelScope.launch {
//                    try {
//                        todoUseCases.addTodo(
//                            Todo(
//                                title = todoTitle.value.text,
//                                description = todoDes.value.text,
//                                timestamp = System.currentTimeMillis(),
//                                id = currentTodoId,
//                                priority = todoPriority.value
//                            ),
//                            todoItems = todoItems.value
//                        )
//
//                    }catch (e: InvalidTodoException){
//                        _eventFlow.emit(UiEvent.ShowSnackbar(message = e.message ?: "Couldn't save note"))
//                    }
//                }
//            }
//            is AddEditTodoEvent.ChangeDescription -> {
//                _todoDes.value = todoDes.value.copy(
//                    isHintVisible = !event.focusState.isFocused
//                            && todoDes.value.text.isBlank()
//                )
//            }
//            is AddEditTodoEvent.EnteredDescription -> {
//                _todoDes.value = todoDes.value.copy(event.value)
//            }
//        }
//    }
//
//}