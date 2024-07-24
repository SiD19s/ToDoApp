package com.example.todoapp.Screens.CommonComp

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.todoapp.R

@Composable
fun BottomBar(modifier: Modifier = Modifier){
    Surface(
        modifier = modifier.fillMaxWidth().height(80.dp),
        color = colorResource(id = R.color.light_grey),
        shape = RoundedCornerShape(topStart = 26.dp, topEnd = 26.dp),
        shadowElevation = 10.dp,
    ){
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround
            ) {
            Icon(
                painter = painterResource(id =R.drawable.home_filled_icon ),
                contentDescription = "",
                tint = colorResource(id = R.color.mid_violet)
            )
            Icon(
                painter = painterResource(id =R.drawable.home_outlined_icon ),
                contentDescription = "",
                tint = colorResource(id = R.color.dark_grey)
            )
            Icon(
                painter = painterResource(id =R.drawable.home_outlined_icon ),
                contentDescription = "",
                tint = colorResource(id = R.color.dark_grey)
            )
            Icon(
                painter = painterResource(id =R.drawable.home_outlined_icon ),
                contentDescription = "",
                tint = colorResource(id = R.color.dark_grey)
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
fun BottomBarPrev(){
    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally){
        BottomBar()
    }

}