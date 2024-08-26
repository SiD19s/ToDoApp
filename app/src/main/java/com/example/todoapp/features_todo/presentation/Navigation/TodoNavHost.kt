package com.example.todoapp.features_todo.presentation.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.todoapp.features_todo.presentation.Screens.AddEditTaskPage.NewNoteScreen
import com.example.todoapp.features_todo.presentation.Screens.TaskPages.TaskPages

@Composable
fun TodoNavHost(
    navController: NavHostController = rememberNavController(),
    startDestination: String = Screen.TodoList.route
) {
    NavHost(navController = navController, startDestination = startDestination) {
        composable(Screen.TodoList.route) {
            TaskPages(
                onAddTodoClick = { /*TODO*/ },
                onTodoClick = {}
            )

        }
        composable(Screen.TodoDetail.route) { backStackEntry ->
            val todoId = backStackEntry.arguments?.getLong("todoId")
            if (todoId != null) {
                NewNoteScreen(title = )
            }
        }
    }
}
