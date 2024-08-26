package com.example.todoapp.features_todo.presentation.Screens.Utils.HomeScreen

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.todoapp.R

@Composable
fun DepthButtton(text:String = "LOGIN"){
    ConstraintLayout(
        modifier = Modifier.fillMaxWidth()
    ){
        val s1 = createRef()
        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(s1) {
                    start.linkTo(parent.start, 3.dp)
                    top.linkTo(parent.top, 3.dp)
                }

            ,
            shape = RoundedCornerShape(6.dp),
            colors = ButtonColors(
                containerColor = Color.Black,
                disabledContentColor = Color.Black,
                contentColor = Color.Black,
                disabledContainerColor = Color.Black
            )
        ) {
        }
        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(6.dp),
            colors = ButtonColors(
                containerColor = colorResource(id = R.color.mid_violet),
                disabledContentColor = Color.White,
                contentColor = Color.White,
                disabledContainerColor = colorResource(id = R.color.mid_violet)
            )
        ) {
            Text(text = text, fontWeight = FontWeight(700))
        }
    }
}