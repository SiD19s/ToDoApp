package com.example.todoapp.features_todo.presentation.Screens.CommonComp

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.todoapp.R
import com.example.todoapp.features_todo.Domain.model.Item


@Composable
fun PriorityTask(title: String,tasks: List<String>,priority: Int){
    Column(
        modifier = Modifier
            .height(240.dp)
            .width(190.dp)
            .border(
                BorderStroke(
                    1.dp,
                    colorResource(id = R.color.dark_grey)
                ),
                shape = RoundedCornerShape(8.dp)
            )
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(vertical = 16.dp)

        ) {
            Box(modifier = Modifier
                .wrapContentSize()
                .padding(horizontal = 8.dp)
            ){
                Image(
                    painter = painterResource(id = R.drawable.pin_image_removebg),
                    contentDescription = "",
                    modifier = Modifier
                        .size(24.dp)
                )
            }

            Text(
                text =title,
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(horizontal = 8.dp)
            )
        }

        LazyColumn(
            modifier = Modifier.padding(bottom = 30.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            items(tasks) { task ->
                ListedTasks(taskName = task)
            }
        }
    }
}



@Composable
fun ListedTasks(isCompleted:Boolean = false,taskName: String){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start,
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                start = 10.dp,
                end = 8.dp,
                top = 7.dp,
                bottom = 7.dp
            )
    ) {
        Icon(
            painter = painterResource(id = R.drawable.unchecked_box) ,
            contentDescription = "",
            modifier = Modifier
                .size(16.dp)
        )

        Text(
            text = taskName,
            fontSize = 16.sp,
            fontWeight = FontWeight.Normal,
            modifier = Modifier.padding(
                start = 8.dp
            ),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )

    }
}


@Preview(
    name = "Light Mode",
    showBackground = true,
    uiMode = UI_MODE_NIGHT_NO
)
@Composable
fun PriorityTaskPreview(){
    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally){
        PriorityTask(
            title = "Job Task",
            tasks = listOf("Complete Assignment","Complete Assignment","Complete Assignment","Complete Assignment"),
            priority = 3
        )

    }

}