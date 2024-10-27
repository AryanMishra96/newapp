package com.example.mistake2
import com.example.mistake2.VideoItem
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import android.util.Log
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.room.util.query
import com.example.mistake2.Netwok.RetrofitInstance
import com.example.mistake2.Netwok.ShowResponse
import kotlinx.coroutines.launch
import com.example.mistake2.Netwok.Episode
import com.example.mistake2.Netwok.VideoItem
import com.example.mistake2.Netwok.VideoResponse
@Composable
fun VideoListScreen(searchQuery: String) {
    val context = LocalContext.current
    val scope = rememberCoroutineScope()
    var videos by remember { mutableStateOf<List<VideoItem>?>(null) }
    var loading by remember { mutableStateOf(true) }
   // var searchQuery by remember { mutableStateOf("") }
    LaunchedEffect(searchQuery) {
        scope.launch {
            try {
                Log.d("VideoListScreen", "Making API request")
               val apiResponse= if(searchQuery.isBlank()) {
                   RetrofitInstance.api.getVideos(maxResults = 10)
               }else{
                   RetrofitInstance.api.searchVideos(query=searchQuery,maxResults = 10)
                }
                    Log.d("VideoListScreen", "API Response: $apiResponse")
                    videos = apiResponse.items
                    Log.d("VideoListScreen","Fetched videos:${videos?.joinToString { it.snippet.title} }")
                } catch (e : Exception) {
                Log.e("VideoListScreen","Error fetching videos:${e.message}")  // Handle any errors
            } finally {
                loading = false
                Log.d("VideoListScreen", "Loading state: $loading")
            }
        }
    }
   /* Column {
        SearchTab { query ->
              searchQuery =query
            loading=true
        }
        */
    if (loading) {
        Text(text = "Loading...")
}else {
        videos?.let { videoList ->
            if(videoList.isNotEmpty()) {
            LazyColumn(modifier = Modifier.fillMaxSize().padding(15.dp)) {
                items(videoList) { video ->
                    VideoItem(video)
                }
            }
        }else{
            Text(text = "No videos available")
        }
    }  ?: run {
        Text(text = "No videos available")
    }
}}


