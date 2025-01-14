package com.compose.recyclerview


import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun DetailScreen(imgRes: Int, title: String, subtitle: String) {
    val detail =
        "Cars are a versatile mode of transportation, designed to provide comfort, convenience, and efficiency. Modern cars come in various types, including sedans, SUVs, trucks, and electric vehicles, each catering to different needs and lifestyles. With advancements in technology, today's cars offer enhanced safety, connectivity, and eco-friendly options, making them essential in daily life."

    var isExpanded by remember { mutableStateOf(false) }

    val imageSize by animateDpAsState(
        targetValue = if (isExpanded) 300.dp else 200.dp,
        animationSpec = tween(durationMillis = 500)
    )

    var isTextVisible by remember { mutableStateOf(false) }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Image(
                painter = painterResource(id = imgRes),
                contentDescription = "Image of $title",
                modifier = Modifier
                    .size(imageSize)
                    .align(Alignment.CenterHorizontally)
                    .padding(bottom = 16.dp)
                    .clickable {
                        isExpanded = !isExpanded
                        isTextVisible = !isTextVisible
                    }
            )

            Text(
                text = title,
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(bottom = 8.dp)
                    .align(Alignment.CenterHorizontally)
            )

            AnimatedVisibility(
                visible = isTextVisible,
                enter = fadeIn(animationSpec = tween(durationMillis = 500)),
                exit = fadeOut(animationSpec = tween(durationMillis = 500))
            ) {
                Text(
                    text = "      $subtitle$detail",
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier
                        .padding(bottom = 8.dp)
                        .align(Alignment.CenterHorizontally)
                )
            }
        }
    }
}
