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
fun SignUpScreen(){
    Column(modifier = Modifier
        .fillMaxWidth(0.94f)
        .fillMaxHeight(0.85f),
        verticalArrangement = Arrangement.Top
    ) {
        Text(
            text = "Sign up into To-Do",
            fontWeight = FontWeight(600),
            fontSize = 32.sp,
            letterSpacing = 1.1.sp

        )
        Column(
            modifier = Modifier
                .padding(vertical = 38.dp)
                .fillMaxHeight(0.43f),
            verticalArrangement = Arrangement.SpaceBetween
        ){
            LabelAndField(text = "Email","Password is wrong")
            LabelAndField(text = "Password","Password is wrong")
            LabelAndField(text = "Confirm Password","Password is wrong")
        }
        Column(
            modifier = Modifier.fillMaxHeight(0.4f),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            DepthButtton("SIGN UP")
            OR()
        }
        Column(modifier = Modifier.padding(top = 32.dp).fillMaxHeight(0.8f),
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
fun SignUpPreview(){
    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally){
        SignUpScreen()
    }

}