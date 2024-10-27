package com.example.mistake2
import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.foundation.Image
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.mistake2.Netwok.Episode
import com.example.mistake2.Netwok.VideoItem
import coil.compose.rememberImagePainter
import androidx.compose.ui.layout.ContentScale

@Composable
fun VideoItem(video: VideoItem) {
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .padding(8.dp)
            .clickable {
                Toast.makeText(context,"Clicked on ${video.snippet.title}",Toast.LENGTH_SHORT).show()
                val intent = Intent(Intent.ACTION_VIEW,Uri.parse("https://www.youtube.com/watch?v=${video.id}"))
                context.startActivity(intent)
            }
    ) {
        LoadImage(
url = video.snippet.thumbnails.default.url,
        modifier = Modifier.height(150.dp)
    .fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(3.dp))
        Text(text = video.snippet.title , style = MaterialTheme.typography.titleLarge)
    }
}