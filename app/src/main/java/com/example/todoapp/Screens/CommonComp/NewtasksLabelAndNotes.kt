package com.example.todoapp.Screens.CommonComp

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.todoapp.R

@Composable
fun NewtasksLabelAndNotes(){
    Column {
        Row(
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .drawBehind {
                    val strokeWidth = 1.dp.toPx() // Adjust stroke width as needed
                    drawLine(
                        Color.LightGray,
                        Offset(0f, 0f),
                        Offset(size.width, 0f),
                        strokeWidth = strokeWidth
                    )
                    drawLine(
                        Color.LightGray,
                        Offset(0f, size.height - strokeWidth),
                        Offset(size.width, size.height - strokeWidth),
                        strokeWidth = strokeWidth
                    )
                }
        ) {
            Text(
                text = "Label :",
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp,
                color = colorResource(id = R.color.dark_grey)
            )
            PriorityDropdownMenu()
        }
        NotesTextField()


    }

}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PriorityDropdownMenu(isExpanded:Boolean = false){
    var expanded by remember { mutableStateOf(isExpanded) }
    val options = listOf(
        priorityIconAndText(R.drawable.circle,"High-Priority"),
        priorityIconAndText(R.drawable.circle,"Mid-Priority"),
        priorityIconAndText(R.drawable.circle,"Low-Priority"),
    )
    var selected by remember { mutableStateOf(options[0]) }

    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = {
            expanded = !expanded
        },

    ) {
        OutlinedTextField(
            value = selected.prioritytext,

            prefix = {
                Icon(
                    painter = painterResource(id = selected.priorityicon),
                    contentDescription = "",
                    modifier = Modifier.padding(end = 6.dp),
                    tint = when (selected.prioritytext) {
                        "High-Priority" -> colorResource(id = R.color.Prority_circle_red)
                        "Mid-Priority" -> colorResource(id = R.color.Prority_circle_blue)
                        else -> colorResource(id = R.color.Prority_circle_green)
                    }
                )
            },
            onValueChange = {},
            readOnly = true,
            textStyle = TextStyle(
                fontSize = 16.sp ,
                color = colorResource(id = R.color.black),
                fontWeight = FontWeight.Medium),
            modifier = Modifier
                .fillMaxWidth()
                .menuAnchor(),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color.Transparent,
                unfocusedBorderColor = Color.Transparent
            )

        )

        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier
                .background(color = Color.White)
                .fillMaxWidth()
        ) {
            options.forEach { item ->
                DropdownMenuItem(
                    text = {
                        Text(
                            text = item.prioritytext,
                            color = Color.Black
                        )
                    },
                    onClick = {
                        selected = item
                        expanded = false
                    }
                )
            }
        }
    }
}

@Composable
fun NotesTextField(notes:String = "") {
    val notes = remember {
        mutableStateOf(notes)
    }
    Box(
        modifier = Modifier.drawBehind {
            val strokeWidth = 1.dp.toPx()

            drawLine(
                Color.LightGray,
                Offset(0f, size.height - strokeWidth),
                Offset(size.width, size.height - strokeWidth),
                strokeWidth = strokeWidth
            )
        }
    ){
        Row(
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .align(Alignment.Center)
                .padding(bottom = 8.dp)
                .fillMaxWidth()
                .wrapContentHeight()

        ) {
            Text(
                text = "Notes :",
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp,
                color = colorResource(id = R.color.dark_grey)
            )
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = notes.value,
                onValueChange = {
                    if (it.length <= 150) {
                        notes.value = it
                    }
                },
                textStyle = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal,
                    color = Color.Black
                ),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color.Transparent,
                    unfocusedBorderColor = Color.Transparent,
                    cursorColor = colorResource(id = R.color.mid_violet) ,
                    selectionColors = TextSelectionColors(
                        handleColor = colorResource(id = R.color.mid_violet),
                        backgroundColor = colorResource(id = R.color.mid_violet).copy(0.4f)
                    )

                )
            )

        }

        Text(
            text = "${notes.value.length}/150", // Replace 100 with your desired character limit
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(end = 4.dp, bottom = 4.dp),
            fontSize = 12.sp,
            fontWeight = FontWeight.Normal,
            color = colorResource(id = R.color.dark_grey)
        )
    }
}



data class priorityIconAndText (
    val priorityicon: Int,
    val prioritytext: String,

    )

@Preview(
    name = "Light Mode",
    showBackground = true,
    uiMode = UI_MODE_NIGHT_NO
)
@Composable
fun NewNotePreview(){
    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally){
        NewtasksLabelAndNotes()
    }

}

