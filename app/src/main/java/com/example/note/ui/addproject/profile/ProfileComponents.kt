package com.example.note.ui.addproject.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.note.ui.theme.green
import com.example.note.ui.theme.typography


@Composable
fun MyPhotosSection() {
    Text(
        text = "My Photography",
        style = typography.h6,
        modifier = Modifier.padding(start = 8.dp, top = 16.dp)
    )
    Divider(modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp))
    val imageModifier = Modifier
        .padding(vertical = 8.dp, horizontal = 4.dp)
        .preferredSize(120.dp)
        .clip(RoundedCornerShape(8.dp))


}

@Composable
fun InterestTag(text: String) {
    val tagModifier = Modifier
        .padding(4.dp)
        .clickable(onClick = {})
        .clip(RoundedCornerShape(4.dp))
        .background(green.copy(alpha = 0.2f))
        .padding(horizontal = 8.dp, vertical = 4.dp)

    Text(
        text = text,
        color = green,
        modifier = tagModifier,
        style = typography.body2.copy(fontWeight = FontWeight.Bold)
    )
}
