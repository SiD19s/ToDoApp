package com.example.todoapp.features_todo.presentation.Screens.TaskPages

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.todoapp.R
import com.example.todoapp.features_todo.presentation.Screens.Utils.BottomBar
import com.example.todoapp.features_todo.presentation.Screens.Utils.HomeScreen.FloatingAddButton

@Composable
fun HomeNewUserScreen(){
    Scaffold(
        containerColor = colorResource(id = R.color.background_white),
    modifier = Modifier
        .fillMaxSize()
        .navigationBarsPadding()
    ) { paddingvalues ->
        ConstraintLayout(modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(paddingvalues)
        ) {
            val (title,subtitle,bottomBar,float) = createRefs()
            Text(
                text = "Welcome Eren,",
                fontSize = 32.sp,
                fontWeight = FontWeight(700),
                modifier = Modifier.constrainAs(title){
                    top.linkTo(parent.top,10.dp)
                    start.linkTo(parent.start,20.dp)
                }
            )

            PicSubText(
                modifier = Modifier.constrainAs(subtitle){
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                }
            )
            BottomBar(
                modifier = Modifier.constrainAs(bottomBar){
                    bottom.linkTo(parent.bottom)
                }
            )
            FloatingAddButton(
                modifier = Modifier.constrainAs(float){
                    bottom.linkTo(bottomBar.top,20.dp)
                    end.linkTo(parent.end,20.dp)
                }
            )
        }
    }
}


@Composable
fun PicSubText(modifier: Modifier = Modifier){
    Column(
        modifier = modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            painter = painterResource(id = R.drawable.lofi_girl),
            contentDescription ="",
            modifier = Modifier
                .width(348.dp)
                .height(300.dp)
                .padding(bottom = 46.dp)
        )
        Text(
            text = "There are no tasks",
            fontSize = 32.sp,
            fontWeight = FontWeight(800),
        )
        Text(
            text = "Create new task or login into google calender to sync the tasks",
            fontSize = 16.sp,
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .padding(top = 12.dp)
            ,
            fontWeight = FontWeight(400),
            textAlign = TextAlign.Center

        )
    }
}
@Preview(
    name = "Light Mode",
    showBackground = true,
    uiMode = UI_MODE_NIGHT_NO
)
@Composable
fun HomeNewPreview(){
    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally){
        HomeNewUserScreen()
    }

}
