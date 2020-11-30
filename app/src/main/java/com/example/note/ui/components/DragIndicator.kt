
package com.example.note.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.preferredHeight
import androidx.compose.foundation.layout.preferredWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.example.note.ui.theme.MaterialColors
import com.example.note.ui.theme.outline

@Composable
fun ColumnScope.DragIndicator() {
    Column(modifier = Modifier.padding(top = 8.dp).align(Alignment.CenterHorizontally)) {
        Box(
            modifier = Modifier.preferredHeight(6.dp).preferredWidth(42.dp)
                .clip(RoundedCornerShape(3.dp)).background(
                    MaterialColors.outline
                )
        )
    }
}
