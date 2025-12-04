package com.example.slicing.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.slicing.R
import com.example.slicing.ui.theme.SlicingTheme

@Composable
fun CategorySection(
    accentYellow: Color,
    primaryDark: Color,
    lightGrey: Color
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "All Categories",
            style = MaterialTheme.typography.titleMedium,
            color = primaryDark
        )
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = "See All",
                fontSize = 13.sp,
                color = Color.Gray
            )
            Icon(
                imageVector = Icons.Default.ArrowForward,
                contentDescription = "See all categories",
                tint = Color.Gray,
                modifier = Modifier.size(12.dp)
            )
        }
    }

    Spacer(modifier = Modifier.height(12.dp))

    val categories = remember {
        listOf(
            CategoryUi("All", R.drawable.all),
            CategoryUi("Hot Dog", R.drawable.hotdog),
            CategoryUi("Burger", R.drawable.burger),
            CategoryUi("Pizza", R.drawable.pizza),
            CategoryUi("More", R.drawable.all),
        )
    }

    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(categories) { category ->
            val isSelected = category.name == "All"
            CategoryChip(
                name = category.name,
                iconRes = category.iconRes,
                isSelected = isSelected,
                selectedColor = accentYellow,
                unselectedColor = lightGrey,
                textColor = primaryDark
            )
        }
    }
}

@Preview
@Composable
fun CategorySectionPreview() {
    SlicingTheme {
        CategorySection(
            accentYellow = MaterialTheme.colorScheme.primary,
            primaryDark = MaterialTheme.colorScheme.onBackground,
            lightGrey = MaterialTheme.colorScheme.surfaceVariant
        )
    }
}


@Composable
private fun CategoryChip(
    name: String,
    iconRes: Int,
    isSelected: Boolean,
    selectedColor: Color,
    unselectedColor: Color,
    textColor: Color
) {
    Surface(
        shape = RoundedCornerShape(20.dp),
        color = if (isSelected) selectedColor else Color.White,
        shadowElevation = if (isSelected) 4.dp else 1.dp
    ) {
        Row(
            modifier = Modifier.padding(horizontal = 18.dp, vertical = 10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // BULATAN BERISI GAMBAR KATEGORI
            Box(
                modifier = Modifier
                    .size(26.dp)
                    .clip(CircleShape)
            ) {
                Image(
                    painter = painterResource(id = iconRes),
                    contentDescription = name,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
            }

            Spacer(modifier = Modifier.width(8.dp))

            Text(
                text = name,
                fontSize = 13.sp,
                fontWeight = if (isSelected) FontWeight.SemiBold else FontWeight.Normal,
                color = if (isSelected) textColor else Color.Gray
            )
        }
    }
}
