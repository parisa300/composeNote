

package com.example.note.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class TagEntity(
    val name: String
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}
