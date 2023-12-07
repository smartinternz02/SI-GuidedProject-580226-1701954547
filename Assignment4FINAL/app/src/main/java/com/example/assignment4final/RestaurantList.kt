package com.example.assignment4final

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.AbsoluteRoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun RestaurantList(navController: NavController) {

    val restaurants = listOf(
        Restaurant("   SundaeFundae", 1, R.drawable.sundaefundae),
        Restaurant("    PizzaMania", 2, R.drawable.pizzamania),
        Restaurant("   DesiZing", 2, R.drawable.zing),
    )

    Box(
        modifier = Modifier
            .background(Color.Black)
            .fillMaxSize()
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.Black)

        ) {
            items(restaurants) { restaurant ->
                RestaurantCard(restaurant, navController)
            }
        }
    }
}

@Composable
fun RestaurantCard(restaurant: Restaurant, navController: NavController) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
            .background(Color.Black)
            .clickable {
                navController.navigate("food_item_list/${restaurant.id}")
            }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Image(
                painter = painterResource(id = restaurant.imageResourceId),
                contentDescription = null,
                modifier = Modifier
                    .size(150.dp)
                    .clip(MaterialTheme.shapes.medium)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = restaurant.name,
                style = TextStyle(
                    fontWeight = FontWeight.Normal,
                    fontSize = 25.sp,
                    fontFamily = FontFamily.Serif,
                    textAlign = TextAlign.End,

                    )

            )


        }
    }
}


