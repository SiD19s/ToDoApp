package com.example.todoapp.features_todo.presentation.Screens.TaskPages

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.todoapp.R
import com.example.todoapp.features_todo.presentation.Screens.TodoViewModel
import com.example.todoapp.features_todo.presentation.Screens.Utils.BottomBar
import com.example.todoapp.features_todo.presentation.Screens.Utils.HomeScreen.FloatingAddButton
import com.example.todoapp.features_todo.presentation.Screens.Utils.OrderSection
import com.example.todoapp.features_todo.presentation.Screens.Utils.PriorityTask


@Composable
fun TaskPages(
    modifier: Modifier = Modifier,
    todoViewModel: TodoViewModel = hiltViewModel(),
    onAddTodoClick: () -> Unit,
    onTodoClick: (Long) -> Unit
) {
    val todoList by todoViewModel.todoList.collectAsState()



    val OrderSectionvisible = remember { mutableStateOf(false) }

    val testingItems = 5

    Scaffold(
        modifier = modifier
            .fillMaxSize()
            .navigationBarsPadding()
        ,
        bottomBar = { BottomBar() },
        floatingActionButton = {
            FloatingAddButton(onClick = onAddTodoClick)
        }
    ) {paddingValues ->
        Column(
            modifier
                .fillMaxWidth()
                .padding(paddingValues)
        ) {
            Row(
                modifier = Modifier
                    .padding(horizontal = 20.dp, vertical = 10.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ){

                Column (
                    modifier = Modifier
                        .height(45.dp)
                        .fillMaxWidth(0.85f)
                        .border(
                            BorderStroke(
                                1.dp, colorResource(id = R.color.dark_grey)
                            ),
                            shape = RoundedCornerShape(8.dp)
                        )
                ){}

                IconButton(
                    onClick = {
                        OrderSectionvisible.value = !OrderSectionvisible.value
                    },
                    modifier = Modifier
                        .wrapContentSize()
                        .padding(start = 8.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.filtericon),
                        contentDescription ="",
                    )
                }
            }
            AnimatedVisibility(
                visible = OrderSectionvisible.value,
                enter = fadeIn() + slideInVertically(),
                exit = fadeOut() + slideOutVertically(),
                modifier = Modifier.fillMaxWidth()
            ) {
                OrderSection(
                    onOrderChange = {

                    }
                )

            }

            LazyVerticalStaggeredGrid(
                columns = StaggeredGridCells.Fixed(2),
                modifier = Modifier
                    .padding(horizontal = 10.dp)
                    .fillMaxWidth()
                    .fillMaxHeight(0.95f),
                contentPadding = PaddingValues(10.dp),
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                verticalItemSpacing = 16.dp,
                content = {
                    items(todoList) { todoWithItems ->
                        PriorityTask(
                            title = todoWithItems.todo.title,
                            tasks = todoWithItems.items,
                            onClick = { onTodoClick(todoWithItems.todo.id ?: 0L) }
                        )
                    }
                }
            )

        }
    }




}


//@Preview(
//    name = "Light Mode",
//    showBackground = true,
//    uiMode = UI_MODE_NIGHT_NO
//)
//@Composable
//fun TasksPagesPreview(){
//    TaskPages()
//}



