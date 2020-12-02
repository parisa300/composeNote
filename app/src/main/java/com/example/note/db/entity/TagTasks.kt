

package com.example.note.db.entity

import androidx.room.Embedded
import androidx.room.Relation

/**
 * Relationship one-to-many Tag-Tasks
 */
data class TagTasks(
    @Embedded val tag: TagEntity,
    @Relation(
        parentColumn = "id",
        entityColumn = "tag_id"
    )
    val tasks: List<TaskEntity>
)
