package com.example.firstcompose.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.example.firstcompose.models.Quote


@Composable
fun quoteList(data: Array<Quote>, onclick: () -> Unit){

    LazyColumn (content = {
        items(data){ it ->

            quoteListItem(it){
                onclick()
            }
        }
    })
}