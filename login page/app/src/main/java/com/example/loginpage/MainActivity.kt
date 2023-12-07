@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.loginpage

import android.content.Context
import android.graphics.Paint
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.AbsoluteRoundedCornerShape
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionContext
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.BlurEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.vector.DefaultTintColor
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import com.example.loginpage.ui.theme.LoginPageTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            LoginUI(applicationContext)

        }
    }
}


@Composable
fun LoginUI(context: Context) {


    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .background(color = Color.Black)
            .fillMaxSize()
    ) {

        Text(
            text = "LOGIN",
            fontFamily = FontFamily.Serif,
            textAlign = TextAlign.Center,
            textDecoration = TextDecoration.Underline,
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 130.dp, bottom = 120.dp)


        )
        OutlinedTextField(
            value = username,
            shape = AbsoluteRoundedCornerShape(200.dp),
            onValueChange = { username = it },
            label = { Text("Enter your username") },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                containerColor = Color.Yellow.copy(alpha = 0.9f),
                cursorColor = Color.Yellow),

            leadingIcon = {
                Icon(Icons.Default.Person, contentDescription = "person", tint = Color.Black)
            },
            modifier = Modifier
                .padding(bottom = 10.dp, top = 10.dp)
                .width(1000.dp)


        )
        OutlinedTextField(
            value = password,
            shape = AbsoluteRoundedCornerShape(200.dp),
            onValueChange = { password = it },
            label = { Text("Enter your password")},
            colors = TextFieldDefaults.outlinedTextFieldColors(
                containerColor = Color.Yellow.copy(alpha = 0.9f),
                cursorColor = Color.Yellow),
            leadingIcon = {
                Icon(Icons.Default.Lock, contentDescription = "password", tint = Color.Black)
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp, top = 10.dp)
            //visualTransformation = PasswordVisualTransformation(),
            //keyboardOptions = KeyboardOptions(KeyboardType = KeyboardType.Password)

        )

        Button(
            onClick = { logged(username, password, context) },
            colors = ButtonDefaults.buttonColors(Color.Blue.copy(alpha = 0.3f)),
            border = BorderStroke(width = 2.dp, color = Color.Green),
            modifier = Modifier
                .fillMaxWidth()
                .padding(all = 20.dp)
                .width(10.dp)
                .padding(all = 20.dp)
                .padding(
                    bottom = 10.dp,
                    top = 20.dp


                ),
        ) {

            Text(
                text = "SUBMIT",
                textAlign = TextAlign.Center,
                color = Color.White,


            )
        }

    }

}


fun logged(username: String, password: String, context: Context) {
    if (username == "saniaanwar" && password == "1234") {
        Toast.makeText(context, "Logged In Successfully!", Toast.LENGTH_SHORT).show()
    } else {
        Toast.makeText(context, "Invalid Login. Please try again.", Toast.LENGTH_SHORT).show()
    }

}


