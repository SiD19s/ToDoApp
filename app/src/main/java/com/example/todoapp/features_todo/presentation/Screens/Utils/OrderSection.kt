package com.example.todoapp.features_todo.presentation.Screens.Utils

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.todoapp.R
import com.example.todoapp.features_todo.Domain.util.OrderType
import com.example.todoapp.features_todo.Domain.util.TodoOrder


@Composable
fun OrderSection(
    modifier: Modifier = Modifier,
    todoOrder: TodoOrder = TodoOrder.Date(OrderType.Descending),
    onOrderChange: (TodoOrder) -> Unit
) {
    Column(modifier = Modifier.fillMaxWidth(0.85f)) {
        Row(modifier = Modifier
            .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            DefaultRadioButton(
                text = "Title",
                selected = todoOrder is TodoOrder.Title,
                onSelected = { onOrderChange(TodoOrder.Title(todoOrder.orderType)) }
            )

            Spacer(modifier = Modifier.width(8.dp))

            DefaultRadioButton(
                text = "Date",
                selected = todoOrder is TodoOrder.Date,
                onSelected = { onOrderChange(TodoOrder.Date(todoOrder.orderType)) }
            )

            Spacer(modifier = Modifier.width(8.dp))

            DefaultRadioButton(
                text = "Priority",
                selected = todoOrder is TodoOrder.Priority,
                onSelected = { onOrderChange(TodoOrder.Priority(todoOrder.orderType)) }
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        //Making second Row
        Row(modifier = Modifier
            .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            DefaultRadioButton(
                text = "Ascending",
                selected = todoOrder.orderType is OrderType.Ascending,
                onSelected = {
                    onOrderChange(todoOrder.copy(OrderType.Ascending))
                }
            )

            Spacer(modifier = Modifier.width(8.dp))

            DefaultRadioButton(
                text = "Descending",
                selected = todoOrder.orderType is OrderType.Descending,
                onSelected = {
                    onOrderChange(todoOrder.copy(OrderType.Descending))
                }
            )
        }

    }
}

@Composable
fun DefaultRadioButton(
    text: String,
    selected: Boolean,
    onSelected: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = Modifier,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        RadioButton(
            selected = selected,
            onClick = onSelected,
            colors = RadioButtonDefaults.colors(
                selectedColor = colorResource(id = R.color.dark_violet),
                unselectedColor = colorResource(id = R.color.black200),
            )
        )

        Spacer(modifier = Modifier.width(2.dp))

        Text(
            text = text,
            fontSize = 16.sp
            )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultRadioButtonPreview() {
//    DefaultRadioButton(
//        text = "sort",
//        selected = false,
//        onSelected = {}
//    )
    Column(modifier = Modifier.fillMaxSize(),) {
        OrderSection(onOrderChange = {})
    }

}