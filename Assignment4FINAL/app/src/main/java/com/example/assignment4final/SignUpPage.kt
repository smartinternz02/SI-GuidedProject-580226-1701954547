package com.example.assignment4final

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.AbsoluteRoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview
fun SignUpScreen() {

    Column() {

        var username by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }
        var name by remember { mutableStateOf("") }
        var email by remember { mutableStateOf("") }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .background(Color.Black)
        ) {
            Image(
                painter = painterResource(id = R.drawable.chef),
                contentDescription = "background",
                modifier = Modifier
                    .fillMaxSize(),
                contentScale = ContentScale.FillHeight
            )

            //
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(5.dp),
                contentAlignment = Alignment.Center
            ) {
                Box(
                    modifier = Modifier
                        .height(600.dp)
                        .width(550.dp)
                        .background(
                            Color(0xF0000000), shape = AbsoluteRoundedCornerShape(35.dp)
                        )

                )

                Text(
                    text = "SIGN UP",
                    fontFamily = FontFamily.Serif,
                    textAlign = TextAlign.Center,
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 500.dp)


                )

                OutlinedTextField(
                    value = name,
                    shape = AbsoluteRoundedCornerShape(200.dp),
                    onValueChange = { name = it },
                    label = { Text("Name") },
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        containerColor = Color.White.copy(alpha = 0.6f),
                        cursorColor = Color.Black
                    ),
                    leadingIcon = {
                        Icon(
                            Icons.Default.AccountCircle,
                            contentDescription = "Name",
                            tint = Color.Black
                        )
                    },
                    modifier = Modifier
                        .padding(bottom = 350.dp)
                        .width(320.dp)
                )

                OutlinedTextField(
                    value = username,
                    shape = AbsoluteRoundedCornerShape(200.dp),
                    onValueChange = { username = it },
                    label = { Text("Username") },
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        containerColor = Color.White.copy(alpha = 0.6f),
                        cursorColor = Color.Black
                    ),

                    leadingIcon = {
                        Icon(
                            Icons.Default.AccountCircle,
                            contentDescription = "account",
                            tint = Color.Black
                        )
                    },
                    modifier = Modifier
                        .padding(bottom = 200.dp)
                        .width(320.dp)


                )
                OutlinedTextField(
                    value = password,
                    shape = AbsoluteRoundedCornerShape(200.dp),
                    onValueChange = { password = it },
                    label = { Text("Password") },
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        containerColor = Color.White.copy(alpha = 0.6f),
                        cursorColor = Color.Black
                    ),
                    leadingIcon = {
                        Icon(
                            Icons.Default.Lock,
                            contentDescription = "password",
                            tint = Color.Black
                        )
                    },
                    modifier = Modifier
                        .padding(bottom = 50.dp)
                        .width(320.dp)
                )

                OutlinedTextField(
                    value = email,
                    shape = AbsoluteRoundedCornerShape(200.dp),
                    onValueChange = { email = it },
                    label = { Text("Email") },
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        containerColor = Color.White.copy(alpha = 0.6f),
                        cursorColor = Color.Black
                    ),
                    leadingIcon = {
                        Icon(
                            Icons.Default.Email,
                            contentDescription = "email",
                            tint = Color.Black
                        )
                    },
                    modifier = Modifier
                        .padding(top = 100.dp)
                        .width(320.dp)
                )
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(150.dp),
                ) {


                        Text(
                            text = "SUBMIT",
                            textAlign = TextAlign.Center,
                            color = Color.White,

                            )
                    }

                }

                        Text(
                            text = "Already have an account? Login Here",
                            fontFamily = FontFamily.Serif,
                            textAlign = TextAlign.Center,
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Cyan,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 160.dp)


                        )
                    }

                }
                Image(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = "logo",
                    alignment = Alignment.BottomCenter,
                    modifier = Modifier.padding(horizontal = 160.dp)
                        .padding(top = 620.dp)

                )


            }


