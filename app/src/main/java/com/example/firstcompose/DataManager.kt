package com.example.firstcompose

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import com.example.firstcompose.models.Quote
import com.google.gson.Gson

object DataManager {

    var data = emptyArray<Quote>()
    var currentQuote: Quote? = null
    var currentPages = mutableStateOf(MainActivity.Pages.LISTING)
    var isDataLoaded = mutableStateOf(false)
    fun loadAssetFromFile(context: Context){
        val inputStream = context.assets.open("quotes.json")
        val size : Int = inputStream.available()
        val buffer = ByteArray(size)

        inputStream.read(buffer)
        inputStream.close()

        val json = String(buffer, Charsets.UTF_8)

        val gson = Gson()

        data = gson.fromJson(json, Array<Quote>::class.java)
        isDataLoaded.value = true
    }


    fun switchPages(quote: Quote?){

        if(currentPages.value == MainActivity.Pages.LISTING){
            currentQuote = quote
            currentPages.value = MainActivity.Pages.DETAILS
        }else{
            currentPages.value = MainActivity.Pages.LISTING
        }
    }
}