package com.example.slicing.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.slicing.R

@Composable
fun EditProfileScreen(
    navController: NavController? = null
) {
    val scrollState = rememberScrollState()
    val orange = Color(0xFFFF7A1A)
    val fieldBg = Color(0xFFF3F5FB)

    var fullName by rememberSaveable { mutableStateOf("San") }
    var email by rememberSaveable { mutableStateOf("bahleel@gmail.com") }
    var phone by rememberSaveable { mutableStateOf("+62 81234567890") }
    var bio by rememberSaveable { mutableStateOf("I love etanol") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {

        // ========== KONTEN YANG DISCROLL ==========
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    top = 60.dp,
                    start = 20.dp,
                    end = 20.dp,
                    bottom = 100.dp
                )
                .verticalScroll(scrollState)
        ) {
            // TOP BAR
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Surface(
                    modifier = Modifier.size(36.dp),
                    shape = CircleShape,
                    color = Color(0xFFEDEFF4)
                ) {
                    IconButton(onClick = { navController?.popBackStack() }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Back",
                            tint = Color(0xFF303345)
                        )
                    }
                }

                Spacer(modifier = Modifier.width(16.dp))

                Text(
                    text = "Edit Profile",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = HomePrimaryDark
                )
            }

            Spacer(modifier = Modifier.height(32.dp))

            // AVATAR + EDIT ICON
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Card(
                    shape = CircleShape,
                    colors = CardDefaults.cardColors(containerColor = Color(0xFFFFF3EC)),
                    elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
                ) {
                    Box(
                        modifier = Modifier.size(130.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.profile),
                            contentDescription = "Profile photo",
                            modifier = Modifier
                                .size(110.dp)
                                .clip(CircleShape),
                            contentScale = ContentScale.Crop
                        )
                    }
                }

                Surface(
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .offset(x = (-140).dp, y = -10.dp)
                        .size(36.dp),
                    shape = CircleShape,
                    color = orange,
                    shadowElevation = 4.dp
                ) {
                    IconButton(onClick = { /* TODO: change photo */ }) {
                        Icon(
                            imageVector = Icons.Default.Edit,
                            contentDescription = "Edit photo",
                            tint = Color.White
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(32.dp))

            // FORM FIELDS
            ProfileLabel(text = "FULL NAME")
            ProfileField(
                value = fullName,
                onValueChange = { fullName = it },
                background = fieldBg
            )

            Spacer(modifier = Modifier.height(16.dp))

            ProfileLabel(text = "EMAIL")
            ProfileField(
                value = email,
                onValueChange = { email = it },
                background = fieldBg
            )

            Spacer(modifier = Modifier.height(16.dp))

            ProfileLabel(text = "PHONE NUMBER")
            ProfileField(
                value = phone,
                onValueChange = { phone = it },
                background = fieldBg
            )

            Spacer(modifier = Modifier.height(16.dp))

            ProfileLabel(text = "BIO")
            ProfileField(
                value = bio,
                onValueChange = { bio = it },
                background = fieldBg,
                singleLine = false,
                minLines = 3
            )
        }

        Button(
            onClick = {
                // TODO: simpan data
            },
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(horizontal = 20.dp, vertical = 40.dp)
                .fillMaxWidth()
                .height(52.dp),
            shape = RoundedCornerShape(16.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = orange,
                contentColor = Color.White
            )
        ) {
            Text(
                text = "SAVE",
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
                letterSpacing = 1.sp,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
private fun ProfileLabel(text: String) {
    Text(
        text = text,
        fontSize = 12.sp,
        fontWeight = FontWeight.SemiBold,
        color = Color(0xFF9FA4B4)
    )
    Spacer(modifier = Modifier.height(6.dp))
}

@Composable
private fun ProfileField(
    value: String,
    onValueChange: (String) -> Unit,
    background: Color,
    singleLine: Boolean = true,
    minLines: Int = 1
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = Modifier.fillMaxWidth(),
        singleLine = singleLine,
        minLines = minLines,
        shape = RoundedCornerShape(16.dp),
        colors = TextFieldDefaults.colors(
            focusedContainerColor = background,
            unfocusedContainerColor = background,
            disabledContainerColor = background,
            cursorColor = HomePrimaryDark,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent
        )
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun EditProfileScreenPreview() {
    val nav = rememberNavController()
    EditProfileScreen(navController = nav)
}
