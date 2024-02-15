package com.example.firstcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Greeting()

        }
    }

    @Preview(showBackground = true, widthDp = 100, heightDp = 500)
    @Composable
    fun Greeting() {
        Text(
            text = "Hello Anshu Singh !",
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.Bold,
            color = Color.Red,
            fontSize = 36.sp,
            textAlign = TextAlign.Center
        )
    }
}
