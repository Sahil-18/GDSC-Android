package com.example.thirdthursdaytrivia

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.thirdthursdaytrivia.models.Restaurant
import com.example.thirdthursdaytrivia.ui.theme.ThirdThursdayTriviaTheme

class MainActivity : ComponentActivity() {
    private val restaurantList = listOf(
        Restaurant(R.string.restaurant1, R.drawable.haldiram, R.string.description1, R.string.rating1, R.string.cost1),
        Restaurant(R.string.restaurant2, R.drawable.pind_punjab, R.string.description2, R.string.rating2, R.string.cost2),
        Restaurant(R.string.restaurant3, R.drawable.get_a_whey, R.string.description3, R.string.rating3, R.string.cost3),
        Restaurant(R.string.restaurant4, R.drawable.kfc, R.string.description4, R.string.rating4, R.string.cost4),
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ThirdThursdayTriviaTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Restaurants(restaurantList = restaurantList)
                }
            }
        }
    }
}

@Composable
fun RestaurantDetails(restaurant: Restaurant){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 20.dp),
        elevation = 5.dp,
        shape = RoundedCornerShape(20.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.Start
        ) {
            Image(
                painter = painterResource(id = restaurant.image),
                contentDescription = stringResource(id = restaurant.name),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 5.dp),
                )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp, end = 10.dp, bottom = 12.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column(
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(text = stringResource(id = restaurant.name), fontWeight = FontWeight.Bold, fontSize = 20.sp)
                    Text(text = stringResource(id = restaurant.description))
                }
                Column(
                    horizontalAlignment = Alignment.End
                ) {
                    Row(
                        modifier = Modifier
                            .padding(start = 4.dp, end = 4.dp, bottom = 4.dp)
                            .background(MaterialTheme.colors.secondaryVariant),
                    ) {
                        Text(text = stringResource(id = restaurant.rating))
                        Image(painter = painterResource(id = R.drawable.ic_baseline_star_24), contentDescription = "star")
                    }
                    Text(text = "Rs " + stringResource(id = restaurant.cost) + " for one")
                }
            }
        }
    }
}


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Restaurants (restaurantList: List<Restaurant>) {
    var value by remember {
        mutableStateOf("")
    }
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp, start = 20.dp, end = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        stickyHeader {
            TextField(
                value = value,
                onValueChange = {
                    value = it
                },
                leadingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.search),
                        modifier = Modifier.padding(0.dp),
                        contentDescription = "search icon"
                    )
                },
                placeholder = { Text(text = stringResource(id = R.string.search_placeholder )) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 20.dp),
                shape = RoundedCornerShape(30),
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.White,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent
                )
            )
        }
        items(items = restaurantList, itemContent = { item ->
            RestaurantDetails(restaurant = item)
        })
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ThirdThursdayTriviaTheme {
        val restaurantList = listOf(
            Restaurant(R.string.restaurant1, R.drawable.haldiram, R.string.description1, R.string.rating1, R.string.cost1),
            Restaurant(R.string.restaurant2, R.drawable.pind_punjab, R.string.description2, R.string.rating2, R.string.cost2),
            Restaurant(R.string.restaurant3, R.drawable.get_a_whey, R.string.description3, R.string.rating3, R.string.cost3),
            Restaurant(R.string.restaurant4, R.drawable.kfc, R.string.description4, R.string.rating4, R.string.cost4),
        )
        Restaurants(restaurantList)
    }
}