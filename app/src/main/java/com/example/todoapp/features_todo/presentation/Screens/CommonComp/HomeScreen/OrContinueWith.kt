package com.example.todoapp.features_todo.presentation.Screens.CommonComp.HomeScreen

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.todoapp.R



@Composable
fun OR(modifer:Modifier = Modifier){
    val OrColor = colorResource(id = R.color.mid_grey)
    Row(
        modifier = modifer
            .fillMaxWidth()
            .padding(bottom = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Canvas(
            modifier = Modifier.weight(1f)
        ) {
            val canvasWidth = size.width
            val canvasHeight = size.height
            drawLine(
                start = Offset(x = 10.dp.toPx(), y = canvasHeight / 2),
                end = Offset(x = canvasWidth-30, y = canvasHeight / 2),
                color = OrColor,
                strokeWidth = 1.dp.toPx()
            )
        }
        Text(
            text = "OR",
            color = OrColor,
            fontWeight = FontWeight(300),
            fontSize = 20.sp
        )
        Canvas(
            modifier = Modifier.weight(1f)
        ) {
            val canvasWidth = size.width
            val canvasHeight = size.height
            drawLine(
                start = Offset(x = 10.dp.toPx(), y = canvasHeight / 2),
                end = Offset(x = canvasWidth-30, y = canvasHeight / 2),
                color = OrColor,
                strokeWidth = 1.dp.toPx()
            )
        }
    }
}

@Composable
fun ContinueWith(icon:Int,name: String){
    Button(
        onClick = { /*TODO*/ },
        colors = ButtonColors(
            contentColor = Color.Unspecified,
            containerColor = Color.White,
            disabledContentColor = Color.White,
            disabledContainerColor = Color.Unspecified
        ),
        border = BorderStroke(1.dp,Color.Black),
        contentPadding = PaddingValues(8.dp),
        shape = RoundedCornerShape(6.dp),
        modifier = Modifier
            .fillMaxWidth()

    ) {
        Row(
            Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Icon(
                painter = painterResource(id = icon),
                contentDescription = "",
                modifier = Modifier
                    .size(28.dp)

            )
            Text(
                text = name,
                color = Color.Black,
                fontSize = 14.sp,
                modifier = Modifier,
                fontWeight = FontWeight(600)
            )
            Icon(
                painter = painterResource(id = icon),
                contentDescription = "",
                modifier = Modifier
                    .size(24.dp),
                tint = Color.Transparent

            )
        }
    }
}

@Preview(
    name = "Light Mode",
    showBackground = true,
    uiMode = UI_MODE_NIGHT_NO
)
@Composable
fun Preview(){
    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally){
    }

}