package com.example.firstcompose

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver

class MainActivity : ComponentActivity() {

    val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // My app Container
            LayoutContainer()
        }
    }


    @Preview(showSystemUi = true, showBackground = false)
    @Composable
    fun LayoutContainer() {// Get the current LifecycleOwner
        val lifecycleOwner = LocalLifecycleOwner.current

        // Use DisposableEffect to register and unregister a LifecycleEventObserver
        DisposableEffect(lifecycleOwner) {
            // Create a LifecycleEventObserver
            val observer = LifecycleEventObserver { _, event ->
                // Handle the lifecycle events
                when (event) {
                    Lifecycle.Event.ON_CREATE -> {
                        // Do something when the activity is created
                        Log.d(TAG, "LayoutContainer: ON_CREATE")
                    }
                    Lifecycle.Event.ON_START -> {
                        // Do something when the activity is started
                        Log.d(TAG, "LayoutContainer: ON_START")
                    }
                    Lifecycle.Event.ON_RESUME -> {
                        // Do something when the activity is resumed
                        Log.d(TAG, "LayoutContainer: ON_RESUME")
                    }
                    Lifecycle.Event.ON_PAUSE -> {
                        // Do something when the activity is paused
                        Log.d(TAG, "LayoutContainer: ON_PAUSE")
                    }
                    Lifecycle.Event.ON_STOP -> {
                        // Do something when the activity is stopped
                        Log.d(TAG, "LayoutContainer: ON_STOP")
                    }
                    Lifecycle.Event.ON_DESTROY -> {
                        // Do something when the activity is destroyed
                        Log.d(TAG, "LayoutContainer: ON_DESTROY")
                    }
                    else -> {
                        Log.d(TAG, "LayoutContainer: else part")
                    }
                }
            }

            // Add the observer to the lifecycle
            lifecycleOwner.lifecycle.addObserver(observer)

            // Remove the observer on dispose
            onDispose {
                Log.d(TAG, "LayoutContainer: onDispose")
                lifecycleOwner.lifecycle.removeObserver(observer)
            }
        }

        Column {
            rowArrangement()
//            columnArrangement()
            listViewItem()
        }
    }

    @Composable
    fun listViewItem(){
        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.Top
        ){
            Image(
                painter =  painterResource(R.drawable.burger),
                contentDescription = "Burger",
                modifier = Modifier.size(100.dp)
                )
            Column( modifier = Modifier.fillMaxWidth().padding(8.dp),
                horizontalAlignment = Alignment.Start) {
                Text(
                        text = "Anshu Singh",
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                fontSize = 24.sp,
                textAlign = TextAlign.Start
                )
                Text(
                    text = "Adroid Developer",
                    style = TextStyle(
                        color = Color.Blue,
                        fontSize = 20.sp,
                        fontFamily = FontFamily.Monospace,
                        letterSpacing = 0.1.em,
                        background = Color.White,
                        textDecoration = TextDecoration.Underline,
                        fontWeight = FontWeight.Light,
                        textAlign = TextAlign.Start
                    ),
                   /* fontWeight = FontWeight.Light,
                    color = Color.Black,
                    fontSize = 20.sp,
                    textAlign = TextAlign.Start*/
                )
            }
        }
    }


    @Composable
    fun rowArrangement() {
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

    @Composable
    fun columnArrangement() {

        Column(
            modifier = Modifier.fillMaxHeight().fillMaxWidth(),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Column Text 1", Modifier.background(Color.Green))
            Text(text = "Column Text 2", Modifier.background(Color.Blue))
            Text(text = "Column Text 3", Modifier.background(Color.Red))
            Text(
                "Overflow Text e".repeat(20),
                Modifier.background(Color.Black),
                color = Color.Red,
                fontSize = 16.sp,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Image(
                modifier = Modifier.size(200.dp),
                painter = painterResource(id = R.drawable.ic_wall_sit),
                colorFilter = ColorFilter.tint(Color.Green),
                contentScale = ContentScale.Fit,
                contentDescription = "Wall Sit Image",
            )
            Button(
                onClick = {
                    Toast.makeText(this@MainActivity, "Hello Anshu Singh", Toast.LENGTH_SHORT)
                        .show()
                },
                // shape = RectangleShape,
                shape = RoundedCornerShape(10.dp),
                //  shape = CutCornerShape(10),

                elevation = ButtonDefaults.buttonElevation(
                    defaultElevation = 10.dp,
                    pressedElevation = 15.dp,
                    disabledElevation = 0.dp
                ),

                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Black,
                    contentColor = Color.White,
                ),
                enabled = true,

                ) {

                Text(text = "Button Text")
                Image(
                    painter = painterResource(id = R.drawable.ic_wall_sit),
                    colorFilter = ColorFilter.tint(Color.White),
                    contentScale = ContentScale.Crop,
                    contentDescription = "Wall Sit Image",
                    modifier = Modifier.size(40.dp)

                )
            }

            TextFieldTest()

        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun TextFieldTest() {

        val name = remember { mutableStateOf("") }

        TextField(
            value = name.value,
            onValueChange = { it ->
                name.value = it
                Toast.makeText(this@MainActivity, it, Toast.LENGTH_SHORT).show()

            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Done),
            label = { Text(text = "Full Name") },
            placeholder = { Text(text = "Enter Name") }
        )
    }
}
