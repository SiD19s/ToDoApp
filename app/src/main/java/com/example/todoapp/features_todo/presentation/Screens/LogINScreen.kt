package com.example.todoapp.features_todo.presentation.Screens

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.todoapp.R
import com.example.todoapp.features_todo.presentation.Screens.Utils.HomeScreen.ContinueWith
import com.example.todoapp.features_todo.presentation.Screens.Utils.HomeScreen.DepthButtton
import com.example.todoapp.features_todo.presentation.Screens.Utils.HomeScreen.LabelAndField
import com.example.todoapp.features_todo.presentation.Screens.Utils.HomeScreen.OR


@Composable
fun LogInScreen(){
    Column(modifier = Modifier
        .fillMaxWidth(0.94f)
        .fillMaxHeight(0.85f),
        verticalArrangement = Arrangement.Top
    ) {
        Text(
            text = "Log in into To-Do",
            fontWeight = FontWeight(600),
            fontSize = 32.sp,
            letterSpacing = 1.1.sp
        )
        Column(
            modifier = Modifier
                .padding(vertical = 38.dp)
                .fillMaxHeight(0.31f),
            verticalArrangement = Arrangement.SpaceBetween
        ){
            LabelAndField(text = "Email","Password is wrong")
            LabelAndField(text = "Password","Password is wrong", extra = {
                Text(
                    text = "forget password?",
                    fontWeight = FontWeight(500),
                    modifier = Modifier.padding(top = 9.dp),
                )
            })
        }
        Column(
            modifier = Modifier.fillMaxHeight(0.32f),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            DepthButtton()
            OR()
        }
        Column(modifier = Modifier.fillMaxHeight(0.6f),
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            ContinueWith(icon = R.drawable.google, name ="Continue with Google" )
            ContinueWith(icon = R.drawable.test_account, name = "Continue as Guest")
        }


    }
}



@Preview(
    name = "Light Mode",
    showBackground = true,
    uiMode = UI_MODE_NIGHT_NO
)
@Composable
fun LogInPreview(){
    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally){
        LogInScreen()
    }

}