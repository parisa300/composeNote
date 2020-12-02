

package com.example.note.model

data class Note(
    val id: Int = 0,
    val name: String,
    val description: String,
    val tasks: List<Task> = arrayListOf()
) {
    override fun toString() = name
}
