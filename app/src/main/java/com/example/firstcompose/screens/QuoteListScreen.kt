package com.example.firstcompose.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.firstcompose.models.Quote

@Composable
fun QuoteListScreen(data: Array<Quote>, onclick: (quote: Quote?) -> Unit) {

    Column() {
        Text(
            text = "Quote App",
            modifier = Modifier.padding(8.dp,24.dp)
                .fillMaxWidth(1f),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.headlineLarge,
        )

        quoteList(data, onclick)
    }
}