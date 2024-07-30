package com.example.todoapp.Screens.CommonComp.HomeScreen

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LabelAndField(
    text : String,
    err : String = "",
    extra : @Composable () -> Unit = {},
    modifier: Modifier = Modifier
){
    Column(modifier.padding(top = 2.dp)) {
        Text(
            text = text,
            fontSize = 14.sp,
            fontWeight = FontWeight(400),
            modifier = Modifier.padding(bottom = 8.dp)
        )
        OutlinedTextField(
            value = "",
            onValueChange = { },
            modifier = Modifier
                .fillMaxWidth()
                .height(42.dp),
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedBorderColor = Color.Black
            ),
            shape = RoundedCornerShape(8.dp)
        )
        Row(
            Modifier.fillMaxWidth().padding(start = 8.dp, top = 2.dp),
            horizontalArrangement = Arrangement.SpaceBetween,

            ) {
            Text(
                text = err,
                fontSize = 12.sp,
                fontWeight = FontWeight(500),
                color = Color.Red,
                letterSpacing = 1.1.sp
            )
            extra()
        }
    }
}

@Preview(name = "Light Mode", showBackground = true, uiMode = UI_MODE_NIGHT_NO)
@Composable
fun LATPrev(){
    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally){
        LabelAndField(text = "Email","error")
    }

}