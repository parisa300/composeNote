

package com.example.note.db.entity

import androidx.room.Embedded
import androidx.room.Relation

/**
 * Relationship one-to-many Project-Tasks
 */
data class ProjectTasks(
    @Embedded val project: ProjectEntity,
    @Relation(
        parentColumn = "id",
        entityColumn = "project_id"
    )
    val tasks: List<TaskEntity>
)
