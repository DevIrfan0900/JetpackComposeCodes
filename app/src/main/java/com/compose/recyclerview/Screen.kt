package com.compose.recyclerview

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun CategoryListScreen(navController: NavHostController) {

    LazyColumn( modifier = Modifier
        .fillMaxSize()
        .background(MaterialTheme.colorScheme.background),content = {
        items(getCategoryList()) { item ->
            BlocCategory(
                imgRes = item.img,
                title = item.title,
                subtitle = item.subTitle,
                onClick = {
                    navController.navigate("detail/${item.img}/${item.title}/${item.subTitle}")

                })
        }
    })
}


@Composable
fun BlocCategory(
    imgRes: Int, title: String, subtitle: String, onClick: () -> Unit // Lambda for click handling
) {
    Card(
        elevation = CardDefaults.elevatedCardElevation(8.dp),
        modifier = Modifier
            .padding(8.dp)
            .clickable { onClick() } // Handle clicks

    ) {
        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(10.dp)) {
            Image(
                painter = painterResource(id = imgRes),
                contentDescription = "",
                modifier = Modifier
                    .size(60.dp)
                    .padding(8.dp)
                    .weight(.2f)
            )
            itemDecoration(title, subtitle, Modifier.weight(.8f))
        }
    }
}

@Composable
private fun itemDecoration(title: String, subtitle: String, modifier: Modifier) {
    Column(modifier = modifier) {
        Text(
            text = title,
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Normal
        )
        Text(
            text = subtitle,
            fontWeight = FontWeight.Normal
        )

    }
}

data class Category(val img: Int, val title: String, val subTitle: String)

fun getCategoryList(): MutableList<Category> {
    val catList = mutableListOf<Category>()
    catList.add(Category(R.drawable.sedan, "Sedan", "Comfortable and stylish"))
    catList.add(Category(R.drawable.suv, "SUV", "Spacious and powerful"))
    catList.add(Category(R.drawable.sedan, "Truck", "Heavy-duty and reliable"))
    catList.add(Category(R.drawable.suv, "Sports Car", "Fast and sleek"))
    catList.add(Category(R.drawable.sedan, "Electric Car", "Eco-friendly and innovative"))
    catList.add(Category(R.drawable.suv, "Sedan", "Comfortable and stylish"))
    catList.add(Category(R.drawable.sedan, "SUV", "Spacious and powerful"))
    catList.add(Category(R.drawable.suv, "Truck", "Heavy-duty and reliable"))
    catList.add(Category(R.drawable.sedan, "Sports Car", "Fast and sleek"))
    catList.add(Category(R.drawable.suv, "Electric Car", "Eco-friendly and innovative"))
    catList.add(Category(R.drawable.sedan, "Sedan", "Comfortable and stylish"))
    catList.add(Category(R.drawable.suv, "SUV", "Spacious and powerful"))
    catList.add(Category(R.drawable.sedan, "Truck", "Heavy-duty and reliable"))
    catList.add(Category(R.drawable.suv, "Sports Car", "Fast and sleek"))
    catList.add(Category(R.drawable.sedan, "Electric Car", "Eco-friendly and innovative"))

    return catList

}


@Composable
fun CategoryListScreenRow(navController: NavHostController) {

    LazyRow(
        modifier = Modifier
            .height(120.dp)
            .background(MaterialTheme.colorScheme.background)
    ) {
        items(getCategoryList()) { item ->
            BlocCategoryRow (
                imgRes = item.img,
                title = item.title,
                subtitle = item.subTitle,
                onClick = {
                    navController.navigate("detail/${item.img}/${item.title}/${item.subTitle}"){
                        launchSingleTop = true
                      //  popUpTo(navController.graph.id) { inclusive = false }
                    }


                })
        }
    }
}
@Composable
fun BlocCategoryRow(
    imgRes: Int, title: String, subtitle: String, onClick: () -> Unit // Lambda for click handling
) {
    Card(
        elevation = CardDefaults.elevatedCardElevation(8.dp),
        modifier = Modifier
            .padding(8.dp)
            .width(200.dp)
            .height(120.dp)
            .clickable { onClick() } // Handle clicks
    ) {
        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(10.dp)) {
            Image(
                painter = painterResource(id = imgRes),
                contentDescription = "",
                modifier = Modifier
                    .size(100.dp)
                    .height(150.dp)
                    .padding(8.dp)
                    .weight(0.3f)
            )
            itemDecorationRow(title, subtitle, Modifier.weight(0.7f))
        }
    }
}

@Composable
private fun itemDecorationRow(title: String, subtitle: String, modifier: Modifier) {
    Column(modifier = modifier.height(200.dp)) {
        Text(
            text = title,
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Normal
        )
        Text(
            text = subtitle,
            fontWeight = FontWeight.Normal
        )
    }
}



