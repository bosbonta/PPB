package com.example.mtixapp

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun SeatSelector(navController: NavHostController, movieTitle: String) {
    var selectedSeats by remember { mutableStateOf(setOf<Pair<Int, Int>>()) }
    val bookedSeats = listOf(Pair(1, 2), Pair(2, 3), Pair(3, 4), Pair(5,5), Pair(0,5), Pair(5,0), Pair(4,3))

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = movieTitle, fontSize = 24.sp, modifier = Modifier.padding(16.dp))
        Text(text = "Screen", fontSize = 18.sp, modifier = Modifier.padding(8.dp))

        // Seat Grid
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            items(6) { row ->
                LazyRow(modifier = Modifier.fillMaxWidth()) {
                    items(6) { col ->
                        SeatBox(
                            row = row,
                            col = col,
                            isBooked = bookedSeats.contains(Pair(row, col)),
                            isSelected = selectedSeats.contains(Pair(row, col)),
                            onSeatSelected = { seat ->
                                selectedSeats = if (selectedSeats.contains(seat)) {
                                    selectedSeats - seat
                                } else {
                                    selectedSeats + seat
                                }
                            }
                        )
                    }
                }
            }
        }

        // Legend
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            LegendItem(color = Color.Gray, description = "Booked")
            LegendItem(color = Color.White, description = "Available")
            LegendItem(color = Color.Blue, description = "Selected")
        }

        Button(
            onClick = {
                val selectedSeatsString = selectedSeats.joinToString(",") { "${it.first}-${it.second}" }
                navController.navigate("payment/$selectedSeatsString")
            },
            modifier = Modifier.padding(top = 16.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Blue)
        ) {
            Text(text = "Confirm Selection", color = Color.White)
        }
    }
}

@Composable
fun SeatBox(
    row: Int,
    col: Int,
    isBooked: Boolean,
    isSelected: Boolean,
    onSeatSelected: (Pair<Int, Int>) -> Unit
) {
    val backgroundColor = when {
        isBooked -> Color.Gray
        isSelected -> Color.Blue
        else -> Color.White
    }

    Box(
        modifier = Modifier
            .size(40.dp)
            .padding(4.dp)
            .background(color = backgroundColor)
            .border(1.dp, Color.Black)
            .clickable(enabled = !isBooked) {
                onSeatSelected(Pair(row, col))
            },
        contentAlignment = Alignment.Center
    ) {
        // Optional: Add any additional content inside the box here
    }
}

@Composable
fun LegendItem(color: Color, description: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(8.dp)
    ) {
        Box(
            modifier = Modifier
                .size(20.dp)
                .background(color = color)
                .border(1.dp, Color.Black)
        )
        Text(
            text = description,
            fontSize = 14.sp,
            modifier = Modifier.padding(start = 8.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewSeatSelectorScreen() {
    SeatSelector(navController = rememberNavController(), movieTitle = "Avengers")
}
