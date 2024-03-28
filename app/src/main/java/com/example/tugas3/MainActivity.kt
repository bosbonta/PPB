package com.example.tugas3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.foundation.Image
import androidx.compose.ui.draw.scale
import androidx.compose.ui.text.font.FontWeight
import com.example.tugas3.ui.theme.Tugas3Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Tugas3Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.Cyan
                ) {
                    GreetingText(
                        message = "Selamat Ulang Tahun Amsal!",
                        from = "Semoga Sehat Selalu:)",
                        painter = painterResource(id = R.drawable.cake),
                        modifier = Modifier.padding(8.dp)

                    )
                }
            }
        }
    }
}

@Composable
fun GreetingText(message: String, from: String, painter: androidx.compose.ui.graphics.painter.Painter, modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Text(
            text = message,
            fontSize = 40.sp,
            lineHeight = 50.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(top = 20.dp)
        )
        Image(
            painter = painter,
            contentDescription = null, // Jika gambar bukan merupakan konten yang dapat diakses
            modifier = Modifier
                .padding(bottom = 40.dp, top = 30.dp)
                .scale(scaleX = .7f, scaleY = .7f)
        )
        Text(
            text = from,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(bottom = 8.dp)
        )

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Tugas3Theme {
        GreetingText(message = "Selamat Ulang Tahun Amsal!", from = "Semoga Sehat Selalu:)", painter = painterResource(id = R.drawable.cake))
    }
}