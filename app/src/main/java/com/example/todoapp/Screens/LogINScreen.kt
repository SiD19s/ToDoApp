package com.example.todoapp.Screens

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.todoapp.R
import com.example.todoapp.Screens.CommonComp.ContinueWith
import com.example.todoapp.Screens.CommonComp.DepthButtton
import com.example.todoapp.Screens.CommonComp.LabelAndField
import com.example.todoapp.Screens.CommonComp.OR


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
            fontSize = 32.sp
        )
        Column(
            modifier = Modifier
                .padding(vertical = 38.dp)
                .fillMaxHeight(0.28f),
            verticalArrangement = Arrangement.SpaceBetween
        ){
            LabelAndField(text = "Email")
            Pass()
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

@Composable
fun Pass(){
    ConstraintLayout {
        val (forgetPass,pass) = createRefs()
        LabelAndField(
            text = "Password",
            modifier = Modifier.constrainAs(pass){
            }
        )
        Text(
            text = "forget password?",
            fontWeight = FontWeight(500),
            modifier = Modifier.constrainAs(forgetPass){
                top.linkTo(pass.bottom,8.dp)
                end.linkTo(pass.end)
            }
        )

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