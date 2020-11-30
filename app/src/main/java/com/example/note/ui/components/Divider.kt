
package com.example.note.ui.components

import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.note.ui.theme.MaterialColors
import com.example.note.ui.theme.outline

@Composable
fun HorizontalDivider(modifier: Modifier = Modifier) {
    Divider(thickness = 1.dp, color = MaterialColors.outline, modifier = modifier)
}
