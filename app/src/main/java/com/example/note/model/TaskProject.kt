

package com.example.note.model

data class TaskProject(
    val id: Int = 0,
    val title: String,
    val description: String,
    val state: TaskState,
    val projectId: Int?,
    val projectName: String?,
    val tagId: Int?
)
