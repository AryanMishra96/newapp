package com.example.mistake2
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
@Composable
fun LoadImage(url : String,modifier: Modifier=Modifier){
   Image( painter = rememberAsyncImagePainter(url),
    contentDescription =null,
    modifier = modifier,
    contentScale = ContentScale.Crop
    )
}