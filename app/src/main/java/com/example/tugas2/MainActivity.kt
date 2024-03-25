package com.example.tugas2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tugas2.ui.theme.Tugas2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Tugas2Theme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    Greeting("Amsal Herbert", "5025201182", "PPB I")
                }
            }
        }
    }
}

@Composable
fun Greeting(nama: String, nrp: String, kelas: String, modifier: Modifier = Modifier) {
    Column (
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF00203F))
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.background(Color(0xFF00203F))
        ){}
        Text(
            text = "Nama: $nama",
            fontSize = 20.sp,
            color = Color(0xFFADEFD1)
        )
        Text(
            text = "NRP: $nrp",
            fontSize = 20.sp,
            color = Color(0xFFADEFD1)
        )
        Text(
            text = "Kelas: $kelas",
            fontSize = 20.sp,
            color = Color(0xFFADEFD1)
        )
        Text(
            text = "Mahasiswa",
            fontSize = 20.sp,
            color = Color(0xFFADEFD1)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Tugas2Theme {
        Greeting("Amsal Herbert", "5025201182", "PPB I")
    }
}