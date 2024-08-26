package com.example.todoapp.features_todo.presentation.Screens.Utils.HomeScreen

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.todoapp.R

@Composable
fun FloatingAddButton(modifier: Modifier = Modifier,onClick: ()-> Unit){
    FloatingActionButton(
        onClick = { onClick },
        shape = RoundedCornerShape(40.dp),
        modifier = modifier.size(65.dp),
        containerColor = colorResource(id = R.color.dark_violet)
    ) {
        Text(
            text = "+",
            color = Color.White,
            fontSize = 40.sp,
            fontWeight = FontWeight(400)
        )
    }
}