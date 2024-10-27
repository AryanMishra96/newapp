package com.example.mistake2
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun  SearchTab (onSearch: (String) ->Unit) {
    var searchText by remember{ mutableStateOf("") }
    TextField(
        value = searchText,
        onValueChange = {
            searchText = it
            onSearch(it)
        },
        placeholder = {Text("Search")},
        modifier = Modifier
            .fillMaxWidth()
            .padding(34.dp),
        colors = TextFieldDefaults.colors(
           // containerColor = MaterialTheme.colorScheme.surface,
            focusedIndicatorColor = MaterialTheme.colorScheme.surface,
            unfocusedIndicatorColor = MaterialTheme.colorScheme.surface
        )

    )
}