package com.example.firstcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LayoutContainer()
        }
    }

    @Composable
    fun LayoutContainer() {
        Column {
            RowArrangement()
            ColumnArrangement()
        }
    }

    @Preview(showSystemUi = true, showBackground = false)
    @Composable
    fun RowArrangement() {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {

            Text(
                text = "Hello Anshu Singh 1!",
                Modifier.background(Color.Red),
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                fontSize = 16.sp,
                textAlign = TextAlign.Center
            )

            Text(
                text = "Hello Anshu Singh 2!",
                Modifier.background(Color.Green),
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.Bold,
                color = Color.Red,
                fontSize = 16.sp,
                textAlign = TextAlign.Center
            )
            Text(
                text = "Hello Anshu Singh 3!",
                Modifier.background(Color.Blue),
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.Bold,
                color = Color.Red,
                fontSize = 16.sp,
                textAlign = TextAlign.Center
            )
        }
    }

    @Preview(showSystemUi = true, showBackground = false)
    @Composable
    fun ColumnArrangement() {
        Column(
            modifier = Modifier.fillMaxHeight().fillMaxWidth(),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Column Text 1", Modifier.background(Color.Green))
            Text(text = "Column Text 2", Modifier.background(Color.Blue))
            Text(text = "Column Text 3", Modifier.background(Color.Red))
        }
    }
}
