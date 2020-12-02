

package com.example.note.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Project")
data class ProjectEntity(
    val name: String,
    val description: String
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}
