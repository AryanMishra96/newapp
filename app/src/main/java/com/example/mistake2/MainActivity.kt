 package com.example.mistake2

 import android.os.Bundle
 import androidx.activity.ComponentActivity
 import androidx.compose.material3.*
 import androidx.compose.material3.Text
 import androidx.compose.runtime.*
 import androidx.activity.compose.setContent
 import com.example.mistake2.ui.theme.Mistake2Theme
 import androidx.compose.runtime.Composable
 import com.example.mistake2.LoginScreen
 import androidx.appcompat.app.AppCompatActivity
 import androidx.activity.enableEdgeToEdge
 import androidx.compose.ui.tooling.preview.Preview
 import androidx.compose.ui.Modifier
 class MainActivity : AppCompatActivity() {
             override fun onCreate(savedInstanceState: Bundle?) {
                 super.onCreate(savedInstanceState)
                 supportActionBar?.hide()
                  enableEdgeToEdge()
                 setContent {
                 //setContentView(R.layout.activity_main)
                 Mistake2Theme {

                     LoginScreen()

                 }
             }
         }}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewLoginScreen() {
    LoginScreen()
    }