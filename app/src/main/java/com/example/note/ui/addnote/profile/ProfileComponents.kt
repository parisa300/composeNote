package com.example.note.ui.addnote.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.note.ui.theme.green
import com.example.note.ui.theme.typography


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
