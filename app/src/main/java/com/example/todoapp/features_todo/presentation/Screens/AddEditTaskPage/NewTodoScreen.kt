package com.example.todoapp.features_todo.presentation.Screens.AddEditTaskPage

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.todoapp.R
import com.example.todoapp.features_todo.presentation.Screens.TodoViewModel
import com.example.todoapp.features_todo.presentation.Screens.Utils.NewtasksLabelAndNotes

@Composable
fun NewNoteScreen(
    todoId: Long,
    viewModel: TodoViewModel = hiltViewModel(),
    navController: NavHostController
){
    val todoDetail by viewModel.todoDetail.collectAsState()
    var newItemText by remember { mutableStateOf("") }

    LaunchedEffect(Unit) {
        viewModel.getTodoDetail(todoId)
    }
    Scaffold(
        containerColor = colorResource(id = R.color.background_white),
        modifier = Modifier
            .fillMaxSize()
            .navigationBarsPadding()
    ) {
        todoDetail.let { todoWithItems ->
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(it),
            ) {
                IconButton(
                    onClick = { navController.popBackStack() },
                    modifier = Modifier.wrapContentSize()
                ) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription ="",
                        modifier = Modifier.size(40.dp)
                    )
                }

                Row (
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 18.dp, top = 40.dp, start = 20.dp, end = 20.dp),

                    ){
                    Text(
                        text = todoWithItems.todo.title,
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        fontSize = 22.sp
                    )
                    Button(
                        shape = RoundedCornerShape(10.dp),
                        onClick = { /*TODO*/ },
                        modifier = Modifier
                            .height(35.dp)
                            .width(86.dp),
                        colors = ButtonColors(
                            containerColor = colorResource(id = R.color.mid_violet),
                            contentColor = colorResource(id = R.color.background_white),
                            disabledContentColor = colorResource(id = R.color.background_white),
                            disabledContainerColor = colorResource(id = R.color.mid_violet),
                        )
                    ) {
                        Text(
                            text = "Save",
                            color = colorResource(id = R.color.background_white),
                            fontWeight = FontWeight.Normal,
                            fontSize = 16.sp
                        )
                    }
                }
                NewtasksLabelAndNotes(Modifier.padding(start = 20.dp, end = 20.dp))
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 32.dp, start = 20.dp, end = 20.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .weight(2f),
                        verticalAlignment = Alignment.CenterVertically

                    ) {
                        Box(
                            Modifier
                                .border(
                                    0.2.dp,
                                    color = Color.Black,
                                    shape = RoundedCornerShape(10.dp)
                                )
                                .background(
                                    colorResource(id = R.color.light_grey),
                                    RoundedCornerShape(10.dp)
                                ),
                        ){
                            Image(
                                painter = painterResource(id = R.drawable.pin_image_removebg),
                                contentDescription = "",
                                modifier = Modifier
                                    .size(30.dp)
                                    .padding(4.dp)
                            )
                        }
                        Text(
                            text ="$title - to-do",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.SemiBold,
                            modifier = Modifier.padding(horizontal = 8.dp)
                        )
                    }

                    Icon(
                        painter = painterResource(id = R.drawable.add),
                        contentDescription ="",
                        tint = colorResource(id = R.color.mid_violet),
                        modifier = Modifier
                            .padding(end = 8.dp)
                            .size(30.dp),
                    )
                }

            }
        }

    }

}

@Preview(
    name = "Light Mode",
    showBackground = true,
    uiMode = UI_MODE_NIGHT_NO
)
@Composable
fun NewNotePreview(){
    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally){
        NewNoteScreen(title = "New Tasks")
    }

}