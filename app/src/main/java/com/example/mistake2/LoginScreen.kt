package com.example.mistake2
import android.content.Intent
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import coil.compose.rememberAsyncImagePainter
import kotlinx.coroutines.Dispatchers

@Composable
fun LoginScreen() {
    val imageUrls = listOf(
        "https://i.pinimg.com/originals/ae/23/7d/ae237deed69f2d579f89eb4c9951fd60.jpg",
        "https://mir-s3-cdn-cf.behance.net/project_modules/1400_opt_1/ec16a4146301677.62addf77becfe.jpg",
        "https://c8.alamy.com/comp/2AGAWRY/the-witcher-poster-2019-credit-netflix-the-hollywood-archive-2AGAWRY.jpg",
        "https://mir-s3-cdn-cf.behance.net/project_modules/1400/62332132039857.566bcebd67c82.jpg"
    )
    val context = LocalContext.current
    var email by remember { mutableStateOf("") }
    val scope = rememberCoroutineScope()
    Column (
        modifier = Modifier.fillMaxSize().padding(10.dp)
    ) {
        ImageSlideshow(imageUrls)
        Spacer(modifier = Modifier.height(10.dp))

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(7.dp),
            contentAlignment = Alignment.Center
        ){
/*Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(3.dp),
        elevation = CardDefaults.cardElevation(2.dp)
    ){*/
            TextField(
                value = email,
                onValueChange = {email = it},
                placeholder = {Text("Email")},

                modifier = Modifier
                    .fillMaxWidth()
                    .height(67.dp),
                colors = TextFieldDefaults.colors(
                     focusedTextColor = Color.Black,
                    unfocusedTextColor = Color.Blue,
                    focusedContainerColor = Color.LightGray,
                    unfocusedContainerColor = Color.LightGray
                )
            )
            Spacer(modifier = Modifier.height(44.dp))
            Button(onClick = {
                if (email.isNotEmpty()) {
                    val user = User(email, null)
                    scope.launch(Dispatchers.IO) {
                        AppDatabase.getDatabase(context).userDao().insert(user)
                        val intent = Intent(context, MainActivity2::class.java)
                        intent.putExtra("EMAIL_EXTRA", email)
                        context.startActivity(intent)
                }
                } else {
                    Toast.makeText(context,"pleasse enter",Toast.LENGTH_SHORT).show()
                }
            }) {
                Text("login")
            }
        }}}