package com.example.retrofitcall

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.retrofitcall.model.PostResponseItem
import com.example.retrofitcall.ui.theme.RetrofitcallTheme

class MainActivity : ComponentActivity() {
    private val apiService: ApiService by lazy { RetrofitInstance.getApiService() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RetrofitcallTheme {
                var posts by remember { mutableStateOf<List<PostResponseItem>>(emptyList()) }
                LaunchedEffect(Unit) {
                    posts = apiService.getPosts()
                }
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    LazyColumn(modifier = Modifier.padding(innerPadding).fillMaxSize()) {

                        items(posts) {
                            Card(
                                modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp)
                                    .fillMaxWidth()
                            ) {
                                    Text(it.userId.toString())
                                    Text(it.title.toString())
                                    Text(it.body.toString())

                                }

                            }


                        }

                    }
                }
            }
        }
    }

