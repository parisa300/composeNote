
package com.example.note.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
import com.example.note.R

@Composable
fun ToDometerTitle(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            asset = vectorResource(id = R.drawable.isotype)
        )
        Text(
            text = stringResource(id = R.string.app_name),
            style = MaterialTheme.typography.h6,
            modifier = Modifier.padding(start = 4.dp)
        )
    }
}

@Preview
@Composable
fun ToDometerTitlePreview() {
    Box {
        ToDometerTitle()
    }
}
