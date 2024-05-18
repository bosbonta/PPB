package com.example.mtixapp

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun PaymentScreen(navController: NavHostController, selectedSeats: List<String>) {
    val pricePerSeat = 20000
    val totalPrice = selectedSeats.size * pricePerSeat

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Payment", fontSize = 24.sp, modifier = Modifier.padding(16.dp))
        Text(text = "Selected Seats: ${selectedSeats.joinToString(", ")}", fontSize = 18.sp, modifier = Modifier.padding(8.dp))
        Text(text = "Total Price: Rp $totalPrice", fontSize = 18.sp, modifier = Modifier.padding(8.dp))

        Button(
            onClick = { /* Handle payment */ },
            modifier = Modifier.padding(top = 16.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Blue)
        ) {
            Text(text = "Pay Now", color = Color.White)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewPaymentScreen() {
    PaymentScreen(navController = rememberNavController(), selectedSeats = listOf("1-1", "2-2"))
}