package com.example.mistake2

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import com.example.mistake2.ui.theme.Mistake2Theme
import androidx.compose.ui.unit.dp
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import androidx.room.util.query

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContent{//View(R.layout.activity_main)
        /*ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets*/
            Mistake2Theme {
            val searchQuery = remember{mutableStateOf("")}
            Column {
                    SearchTab { query ->
                        searchQuery.value=query
                        Log.d("Search ", "Searching for: $query")
                    }
    VideoListScreen(searchQuery.value)
        }}}}}
/*@Preview
@Composable
fun SearchTab() {
    Mistake2Theme {
    val
        Log.d("Search", "searched : $query")
        }
        VideoListScreen()
    }
}}*/
