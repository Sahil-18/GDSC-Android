package com.example.firstcomposeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.firstcomposeapp.ui.theme.FirstComposeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FirstComposeAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.White
                ) {
                    ThursdayTriviaView(name = "Sahil Purohit",title = "Jetpack Compose")
                }
            }
        }
    }
}

@Composable
fun ThursdayTriviaView(name: String, title: String) {
    val loveEmoji: Painter = painterResource(id = R.drawable.heart_imoji)
    val composeLogo : Painter = painterResource(id = R.drawable.jetpack_compose_icon)
    Column (
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxHeight().fillMaxWidth()
    ){
        Image(painter = composeLogo,
            contentDescription = null,
            modifier = Modifier
                .wrapContentWidth(align = Alignment.CenterHorizontally)
        )
        Text(text = name,
            color = Color(56, 112, 179, 255),
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                fontSize = 25.sp
            ),
            modifier = Modifier
                .wrapContentWidth(align = Alignment.CenterHorizontally)
                .padding(bottom = 15.dp)
        )
        Image(painter = loveEmoji,
            contentDescription = null,
            modifier = Modifier
                .wrapContentWidth(align = Alignment.CenterHorizontally)
                .padding(bottom = 15.dp)
        )
        Text(text = title,
            color = Color(8, 48, 66, 255),
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp
            ),
            modifier = Modifier
                .wrapContentWidth(align = Alignment.CenterHorizontally)
        )
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    FirstComposeAppTheme {
        ThursdayTriviaView(name = "Sahil Purohit",title = "Jetpack Compose")
    }
}