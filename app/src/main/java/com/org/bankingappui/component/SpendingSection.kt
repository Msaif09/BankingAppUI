package com.org.bankingappui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.MedicalServices
import androidx.compose.material.icons.rounded.Restaurant
import androidx.compose.material.icons.rounded.ShoppingBag
import androidx.compose.material.icons.rounded.Subscriptions
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.toFontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.org.bankingappui.R
import com.org.bankingappui.SpendingItem
import com.org.bankingappui.randomColor


val spendingItems = listOf(
    SpendingItem(
        name = "Food",
        color = randomColor(),
        amount = 123.23f,
        icon = Icons.Rounded.Restaurant
    ),
    SpendingItem(
        name = "Shopping",
        color = randomColor(),
        amount = 143.83f,
        icon = Icons.Rounded.ShoppingBag
    ),
    SpendingItem(
        name = "Subscription",
        color = randomColor(),
        amount = 166.63f,
        icon = Icons.Rounded.Subscriptions
    ),
    SpendingItem(
        name = "Health",
        color = randomColor(),
        amount = 84f,
        icon = Icons.Rounded.MedicalServices
    ),
)

@Composable
fun SpendingSection(modifier: Modifier){
    Text(
        modifier = Modifier.padding(horizontal = 22.dp),
        text = "Spending Breakdown",
        fontFamily = Font(R.font.playb).toFontFamily(),
        fontSize = 25.sp
    )
    Spacer(modifier = Modifier.height(16.dp))
    SpendingList(
        modifier = modifier
    )
}

@Composable
fun SpendingItem(
    modifier: Modifier,
    spendingItem: SpendingItem
    ){
    ElevatedCard(
        modifier = modifier
            .size(150.dp),
        shape = RoundedCornerShape(20.dp)
    ) {
        Column (
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .background(spendingItem.color.copy(0.5f))
                .padding(20.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ){
            Icon(
                imageVector = spendingItem.icon, 
                contentDescription = null,
                tint = Color.Black.copy(0.8f),
                modifier = Modifier.size(33.dp)
            )
            Text(
                text = spendingItem.name,
                fontSize = 15.sp,
                color = Color.Black.copy(0.7f)
            )
            
            Text(
                text = "$" + spendingItem.amount.toString(),
                fontFamily = Font(R.font.playb).toFontFamily(),
                fontSize = 23.sp,
                color = Color.Black.copy(0.8f)
            )
            
        }
    }
}

@Composable
fun SpendingList(modifier: Modifier){
    LazyRow (
        modifier = modifier,
        contentPadding = PaddingValues(16.dp)
    ){
        itemsIndexed(spendingItems){
            index, item ->
            SpendingItem(
                modifier = Modifier.padding(horizontal = 8.dp),
                spendingItem = item
            )
            Spacer(modifier = Modifier.width(16.dp))
        }
    }
}