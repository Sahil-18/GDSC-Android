package com.example.todolistapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.todolistapp.ui.theme.ToDoListAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ToDoListAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ToDoList()
                }
            }
        }
    }
}

@Composable
fun ToDoItem(toDo: String, onValueChange: (String) -> Unit, onButtonClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 10.dp, top = 20.dp, end = 10.dp, bottom = 40.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        TextField(
            value = toDo,
            onValueChange = onValueChange,
            label = {Text("Add to do item")},
            singleLine = true,
            modifier = Modifier
                .height(60.dp)
                .width(200.dp)
        )
        Spacer(modifier = Modifier.padding(20.dp))
        Button(
            onClick = onButtonClick,
            modifier = Modifier
                .height(40.dp)
                .width(70.dp),
        ) {
            Text(text = "Add")
        }
    }
}

@Composable
fun ToDoListOneItem(value : String, onButtonClick: (String) -> Unit){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 10.dp, top = 20.dp, end = 10.dp),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.Top
    ) {
        Text(
            text = value,
            modifier = Modifier
                .height(40.dp)
                .width(200.dp)
        )
        Button(
            onClick = { onButtonClick(value) },
            modifier = Modifier
                .height(40.dp)
                .width(90.dp)
        ) {
            Text(text = "Delete")
        }
    }
}

@Composable
fun ToDoItemList(toDoList : ArrayList<String>, onClick: (String) -> Unit) {
//    val onClick: (value:String) -> Unit = {
//        toDoList.remove(it)
//    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(top = 20.dp, start = 40.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Top,
    ) {
        Text(
            text = "To Do items",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Blue
        )
        for(item in toDoList){
            ToDoListOneItem(value = item,
                onButtonClick = onClick
            )
        }
    }
}

@SuppressLint("MutableCollectionMutableState")
@Composable
fun ToDoList() {
    var toDo by remember { mutableStateOf("") }
    val toDoList by remember { mutableStateOf(ArrayList<String>()) }
    val onClick: (value:String) -> Unit = {
        toDoList.remove(it)
    }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(top = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
    ) {
        ToDoItem(toDo = toDo,
            onValueChange = {toDo = it},
            onButtonClick = {
                if(toDo != "") {
                    toDoList.add(toDo)
                    toDo = ""
                }
            }
        )
        ToDoItemList(toDoList = toDoList,
            onClick = onClick
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ToDoListAppTheme {
        ToDoList()
    }
}