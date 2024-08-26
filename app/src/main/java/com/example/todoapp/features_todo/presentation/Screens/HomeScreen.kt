package com.example.todoapp.features_todo.presentation.Screens

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.todoapp.R
import com.example.todoapp.features_todo.presentation.Screens.Utils.HomeScreen.DepthButtton

@Composable
fun HomeScreen(){
   Box(modifier = Modifier.fillMaxSize()){
       Column(
           Modifier
               .align(Alignment.Center)
               .fillMaxWidth(0.94f)
               .fillMaxHeight(0.7f),
           horizontalAlignment = Alignment.CenterHorizontally,
           verticalArrangement = Arrangement.SpaceBetween
       ) {
           Image(
               painter = painterResource(id = R.drawable.amico)
               , contentDescription = "",
               modifier = Modifier
                   .fillMaxWidth()
                   .size(400.dp),
               contentScale = ContentScale.Fit,
           )
           Column(
               modifier = Modifier.fillMaxWidth(),
           ){
               DepthButtton()

               Button(
                   onClick = { /*TODO*/ },
                   modifier = Modifier
                       .fillMaxWidth()
                       .padding(top = 12.dp),
                   shape = RoundedCornerShape(6.dp),
                   border = BorderStroke(
                       1.dp,
                       colorResource(id = R.color.black200)
                   ),
                   colors = ButtonColors(
                       containerColor = Color.White,
                       disabledContentColor = colorResource(id = R.color.black200),
                       contentColor = colorResource(id = R.color.black200),
                       disabledContainerColor = Color.White
                   )

                   ) {
                   Text(
                       text = "SIGN UP",
                       color = colorResource(id = R.color.black200),
                       fontWeight = FontWeight(700)
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
fun Prev(){
    HomeScreen()
}