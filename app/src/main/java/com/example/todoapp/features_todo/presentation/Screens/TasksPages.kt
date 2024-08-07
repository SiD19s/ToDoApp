package com.example.todoapp.features_todo.presentation.Screens

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.graphics.Movie
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.lazy.staggeredgrid.rememberLazyStaggeredGridState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.todoapp.R
import com.example.todoapp.features_todo.presentation.Screens.CommonComp.BottomBar
import com.example.todoapp.features_todo.presentation.Screens.CommonComp.PriorityTask


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TaskPagesTopBar() {
    val testingItems = 5
    ConstraintLayout {
        val (searchRow, LazyGrid,bottomBar,Float) = createRefs()
        Row(
            modifier = Modifier
                .constrainAs(searchRow){
                    top.linkTo(parent.top,14.dp)
                }
                .padding(horizontal = 20.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically

        ){

            Column (
                modifier = Modifier
                    .height(45.dp)
                    .fillMaxWidth(0.85f)
                    .border(
                        BorderStroke(
                            1.dp, colorResource(id = R.color.dark_grey)
                        ),
                        shape = RoundedCornerShape(8.dp)
                    )
            ){}

            Icon(
                painter = painterResource(id = R.drawable.filtericon),
                contentDescription ="",
                modifier = Modifier
            )
        }

        LazyVerticalStaggeredGrid(
            columns = StaggeredGridCells.Fixed(2),
            modifier = Modifier
                .constrainAs(LazyGrid){
                    top.linkTo(searchRow.bottom,18.dp)
                    bottom.linkTo(bottomBar.top,24.dp)
                }
                .padding(horizontal = 10.dp)
                .fillMaxWidth()
                .fillMaxHeight(0.8f),
            contentPadding = PaddingValues(10.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            verticalItemSpacing = 16.dp,
            content = {

                items(testingItems) {item->
                    PriorityTask(
                        title = "Job Task",
                        tasks = listOf("Complete Assignment","Complete Assignment","Complete Assignment","Complete Assignment"),
                        priority = 3
                    )
                }
            }
        )
        BottomBar(
            modifier = Modifier.constrainAs(bottomBar){
                bottom.linkTo(parent.bottom)
            }
        )
        FloatingActionButton(
            onClick = { /*TODO*/ },
            shape = RoundedCornerShape(40.dp),
            modifier = Modifier.size(65.dp)
                .constrainAs(Float){
                    bottom.linkTo(LazyGrid.bottom,10.dp)
                    end.linkTo(LazyGrid.end,20.dp)
                },
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

}




@Preview(
    name = "Light Mode",
    showBackground = true,
    uiMode = UI_MODE_NIGHT_NO
)
@Composable
fun TaskPagesPreview(){
//    Column(modifier = Modifier.fillMaxSize(),
//        verticalArrangement = Arrangement.Center,
//        horizontalAlignment = Alignment.CenterHorizontally) {
//
//
//    }
    TaskPagesTopBar()
}