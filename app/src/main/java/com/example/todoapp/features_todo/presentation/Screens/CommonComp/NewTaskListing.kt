package com.example.todoapp.features_todo.presentation.Screens.CommonComp

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.todoapp.R
import com.example.todoapp.features_todo.presentation.Screens.NewNoteScreen

@Composable
fun NewTaskListing(isCompleted:Boolean = false){
    val newTask = remember {
        mutableStateOf("example")
    }
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(onClick = { /*TODO*/ }) {
            Icon(
                painter = painterResource(id = R.drawable.apps),
                contentDescription ="",
                modifier = Modifier.size(14.dp,19.dp)
            )
        }
        OutlinedTextField(
            value = newTask.value ,
            onValueChange = {
                newTask.value = it
            },
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.unchecked_box) ,
                    contentDescription = "",
                    modifier = Modifier.size(22.dp)
                )
            },
            textStyle = TextStyle(
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = 4.dp),
            shape = RoundedCornerShape(10.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = colorResource(id = R.color.light_grey),
                unfocusedContainerColor = colorResource(id = R.color.light_grey),
                cursorColor = colorResource(id = R.color.mid_violet) ,
                selectionColors = TextSelectionColors(
                    handleColor = colorResource(id = R.color.mid_violet),
                    backgroundColor = colorResource(id = R.color.mid_violet).copy(0.4f)
                )
            )
        )
    }
}

@Preview(
    name = "Light Mode",
    showBackground = true,
    uiMode = UI_MODE_NIGHT_NO
)
@Composable
fun NewTaskListingPreview(){
    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally){
        NewTaskListing()
    }

}