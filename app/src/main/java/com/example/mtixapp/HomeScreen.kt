package com.example.mtixapp

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun HomeScreen(navController: NavHostController) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {
        item {
            Text(
                text = "Now Playing",
                modifier = Modifier
                    .background(Color.Black.copy(alpha = 0.7f))
                    .fillMaxWidth()
                    .padding(8.dp),
                color = Color.White,
                fontSize = 20.sp
            )
        }

        item {
            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(getNowPlayingMovies()) { posterFilm ->
                    Column(
                        modifier = Modifier
                            .width(150.dp)
                            .padding(8.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        MoviePoster(posterFilm = posterFilm, navController = navController, clickable = true)
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(text = posterFilm.namaFilm, fontSize = 16.sp)
                        Text(text = posterFilm.genreFilm, fontSize = 14.sp, color = Color.Gray)
                    }
                }
            }
        }

        item {
            Text(
                text = "Coming Soon",
                modifier = Modifier
                    .background(Color.Black.copy(alpha = 0.7f))
                    .fillMaxWidth()
                    .padding(8.dp),
                color = Color.White,
                fontSize = 20.sp
            )
        }

        items(getComingSoonMovies()) { posterFilm ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                MoviePoster(posterFilm = posterFilm, navController = navController, clickable = false)
                Spacer(modifier = Modifier.width(16.dp))
                Column {
                    Text(text = posterFilm.namaFilm, fontSize = 16.sp)
                    Text(text = posterFilm.genreFilm, fontSize = 14.sp, color = Color.Gray)
                }
            }
        }
    }
}

@Composable
fun MoviePoster(posterFilm: PosterFilm, navController: NavHostController, clickable: Boolean) {
    Box(
        modifier = Modifier
            .size(width = 150.dp, height = 200.dp)
            .clickable(enabled = clickable) {
                if (clickable) {
                    navController.navigate("seat/${posterFilm.namaFilm}")
                }
            },
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = posterFilm.posterResId),
            contentDescription = posterFilm.namaFilm,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
    }
}

data class PosterFilm(val namaFilm: String, val genreFilm: String, val posterResId: Int)

fun getNowPlayingMovies(): List<PosterFilm> {
    return listOf(
        PosterFilm(namaFilm = "Bangkit", genreFilm = "Adventure", posterResId = R.drawable.movie1),
        PosterFilm(namaFilm = "Thor", genreFilm = "Superhero", posterResId = R.drawable.movie2),
        PosterFilm(namaFilm = "Jujutsu Kaisen 0", genreFilm = "Anime", posterResId = R.drawable.movie3),
        PosterFilm(namaFilm = "Godzila x Kong", genreFilm = "Action", posterResId = R.drawable.movie4)
    )
}

fun getComingSoonMovies(): List<PosterFilm> {
    return listOf(
        PosterFilm(namaFilm = "The Architecture of Love", genreFilm = "Romance", posterResId = R.drawable.movie5),
        PosterFilm(namaFilm = "Siksa Kubur", genreFilm = "Horor", posterResId = R.drawable.movie6),
        PosterFilm(namaFilm = "The Fall Guy", genreFilm = "Comedy", posterResId = R.drawable.movie7)
    )
}

@Preview
@Composable
fun PreviewHomeScreen() {
    HomeScreen(navController = rememberNavController())
}
