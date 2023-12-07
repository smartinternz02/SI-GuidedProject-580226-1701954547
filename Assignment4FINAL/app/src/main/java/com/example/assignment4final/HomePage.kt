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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun FoodItemList(restaurantId: Int,navController: NavController) {
    val restaurantName = when (restaurantId) {
        1 -> "SundaeFundae"
        2 -> "PizzaMania"
        3 -> "DesiZing"
        else -> "Unknown Restaurant"
    }

    val foodItems = when (restaurantId) {

        1 -> listOf(
            Fooditem("  Brownie", 100.00, R.drawable.brownie),
            Fooditem("  Waffles", 180.00, R.drawable.waffle),
            Fooditem("    Cake", 75.00, R.drawable.cake),
            Fooditem("   Shake", 200.00, R.drawable.shake),
            Fooditem("  Ice Cream", 60.00, R.drawable.icecream)

        )

        2 -> listOf(
            Fooditem("Pepperoni Pizza", 300.00, R.drawable.pepperoni),
            Fooditem("Barbeque Blast", 300.00, R.drawable.bbq),
            Fooditem("Classic Cheese", 150.00, R.drawable.cheese),
            Fooditem("Veggie Lover", 200.00, R.drawable.veg),
            Fooditem("Mushroom Maniac", 170.00, R.drawable.mushroom)
        )

        3 -> listOf(
            Fooditem("Chicken Biryani", 200.00, R.drawable.biryani),
            Fooditem("Paneer Butter Masala", 150.00, R.drawable.paneer),
            Fooditem("Pani Puri", 110.00, R.drawable.panipuri),
            Fooditem("Classic Chai", 50.00, R.drawable.chai),
            Fooditem("Kebabs", 120.00, R.drawable.kebab)
        )


        else -> emptyList()
    }

    var selectedFoodItem by remember { mutableStateOf<Fooditem?>(null) }
    Box(
        modifier = Modifier.fillMaxSize()
            .background(Color.Black)
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.Black)
        ) {
            item {
                Text(
                    text = "Food Items at $restaurantName",
                    style = TextStyle(
                        fontSize = 24.sp,
                        fontWeight = FontWeight.SemiBold,
                        fontFamily = FontFamily.Serif,
                        color = Color.White
                    ),
                    modifier = Modifier
                        .padding(20.dp)
                        .padding(top=45.dp)
                )
            }
            items(foodItems) { foodItem ->
                FoodItemCard(
                    foodItem = foodItem,
                    isExpanded = foodItem == selectedFoodItem,
                    onClick = {
                        selectedFoodItem = if (selectedFoodItem == foodItem) null else foodItem
                    }
                )
            }
        }
    }
    IconButton(
        onClick = {
            navController.popBackStack()
        },
        modifier = Modifier.padding(16.dp)
    ) {
        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = "Back to Restaurants",
            tint = Color.White
        )
    }
}
@Composable
fun FoodItemCard(foodItem: Fooditem, isExpanded: Boolean, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
            .clickable { onClick() }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = foodItem.imageResourceId),
                contentDescription = null,
                modifier = Modifier
                    .size(150.dp)
                    .clip(MaterialTheme.shapes.medium)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = foodItem.name,
                style = TextStyle(
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 25.sp),
                fontFamily = FontFamily.Serif

            )

            Spacer(modifier = Modifier.height(8.dp))

            if (isExpanded) {
                Text(
                    text = "Price: $${foodItem.price}",
                    style = TextStyle(
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Normal,
                        fontFamily = FontFamily.Monospace,
                        textAlign = TextAlign.End
                    )
                )
            }
        }
    }
}
