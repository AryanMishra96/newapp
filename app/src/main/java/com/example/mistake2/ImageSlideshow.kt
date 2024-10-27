package com.example.mistake2
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import kotlinx.coroutines.delay
@Composable
fun ImageSlideshow(imageUrls: List<String>) {
    var currentIndex by remember { mutableStateOf(0) }
    LaunchedEffect(Unit) {
        while (true){
            delay(2500)
            currentIndex = (currentIndex + 1)% imageUrls.size
        }
    }
    val  displayedImages = List(2) {index ->
        imageUrls[(currentIndex + index)%imageUrls.size]
    }
    LazyRow (modifier = Modifier
        .fillMaxWidth()
        .height(200.dp)
        .padding(4.dp),
        horizontalArrangement = Arrangement.spacedBy(1.dp)
    ) {
        items(displayedImages) { url ->
            val painter = rememberAsyncImagePainter(url)
            Image(
                painter = painter,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(2.dp)
                    .size(210.dp)
            )
        }
    }}