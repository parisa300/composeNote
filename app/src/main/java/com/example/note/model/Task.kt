

package com.example.note.model

data class Task(
    val id: Int = 0,
    val title: String,
    val description: String,
    val state: TaskState,
    val projectId: Int?,
    val tagId: Int?
)
