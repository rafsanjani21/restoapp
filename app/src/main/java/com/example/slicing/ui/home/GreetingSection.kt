package com.example.slicing.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.slicing.R

@Composable
fun GreetingSection(onProfileClick: () -> Unit) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
    Column {
        Text(
            text = "Hey San,",
            fontSize = 16.sp,
            color = HomePrimaryDark
        )
        Text(
            text = "Good Afternoon!",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = HomePrimaryDark
        )
    }

    Image(modifier = Modifier
        .size(48.dp)
        .clip(CircleShape)
        .clickable { onProfileClick() },
        painter = painterResource(id = R.drawable.profile),
        contentDescription = "Profile photo",
        contentScale = ContentScale.Crop
    )
}
}

@Preview
@Composable
fun GreetingSectionPreview() {
    GreetingSection(onProfileClick = {})
}