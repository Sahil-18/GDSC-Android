package com.example.todolistapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
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
    Row {
        TextField(
            value = toDo,
            onValueChange = onValueChange,
            label = {Text("Add to do item")},
            singleLine = true
        )
        Button(onClick = onButtonClick) {
            Text(text = "Add item")
        }
    }
}

@Composable
fun ToDoListOneItem(value : String, onButtonClick: (String) -> Unit){
    Row() {
        Text(text = value)
        Button(onClick = { onButtonClick(value) }) {
            Text(text = "Delete this item")
        }
    }
}

@Composable
fun ToDoItemList(toDoList : ArrayList<String>, onClick: (String) -> Unit) {
//    val onClick: (value:String) -> Unit = {
//        toDoList.remove(it)
//    }

    Column() {
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
    Column {
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