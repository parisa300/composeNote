
package com.example.note.ui.utils

import androidx.annotation.FloatRange

object ProgressUtil {

    fun getPercentage(@FloatRange(from = 0.0, to = 1.0) progress: Float) =
        progress.takeIf { it in 0.0..1.0 }?.let { "${(it * 100).toInt()}%" } ?: "-%"
}
