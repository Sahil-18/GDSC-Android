package com.example.secondthursdaytrivia

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.secondthursdaytrivia.ui.theme.SecondThursdayTriviaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SecondThursdayTriviaTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.White
                ) {
                    View()
                }
            }
        }
    }
}

@Composable
fun ViewButton(value: String){
    Button(
        onClick = { },
        shape = RoundedCornerShape(15),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color(0xFF6200EE)
        ),
        modifier = Modifier
            .size(100.dp)
    ) {
            Text(
                text = value,
                color = Color.White
            )
        }
}


@Composable
fun ViewText(heading: String, content: String){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = heading,
            fontSize = 16.sp
        )
        Text(text = content,
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun View(){
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ){
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Image(painter = painterResource(id = R.drawable.banner),
                contentDescription = "",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 10.dp)
            )
            Text(text = "Score",
                fontSize = 30.sp
            )
            Text(text = "0 / 4",
                modifier = Modifier
                    .padding(bottom = 50.dp),
                fontWeight = FontWeight.Bold,
                fontSize = 50.sp
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 50.dp),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            ViewText(heading = "You Chose",
                content = "Rock"
            )
            ViewText(heading = "Android Chose",
                content = "Paper"
            )
        }
        Column(
            modifier = Modifier
                .padding(bottom = 20.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 30.dp),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                ViewButton(value = "Rock")
                ViewButton(value = "Paper")
                ViewButton(value = "Scissors")
            }
            Text(text = "#JetpackCompose",
                fontSize = 20.sp,
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.Bold,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SecondThursdayTriviaTheme {
        View()
    }
}