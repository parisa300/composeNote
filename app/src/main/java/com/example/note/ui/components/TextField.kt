
package com.example.note.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import com.example.note.ui.theme.MaterialColors
import com.example.note.ui.theme.MaterialTypography

@Composable
fun TextField(
    value: String,
    onValueChanged: (String) -> Unit,
    label: @Composable (() -> Unit)? = null,
    isErrorValue: Boolean = false,
    errorMessage: String = "",
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    onImeActionPerformed: (ImeAction, SoftwareKeyboardController?) -> Unit = { _, _ -> },
    modifier: Modifier = Modifier.fillMaxWidth(),
) {
    Column(
        modifier = Modifier.padding(
            start = 16.dp,
            end = 16.dp,
            top = 8.dp
        )
    ) {
        OutlinedTextField(
            value = value,
            onValueChange = onValueChanged,
            label = label,
            modifier = modifier,
            keyboardOptions = keyboardOptions,
            isErrorValue = isErrorValue,
            onImeActionPerformed = onImeActionPerformed
        )
        if (isErrorValue) {
            Text(
                errorMessage,
                color = MaterialColors.error,
                style = MaterialTypography.caption
            )
        }
    }
}
