

package com.example.note.mapper

import com.example.note.db.entity.TaskEntity
import com.example.note.model.Task

object TaskMapper {
    fun TaskEntity.toDomain() = Task(
        id = id,
        title = title,
        description = description,
        state = state,
        projectId = projectId,
        tagId = tagId
    )

    fun Task.toEntity() = TaskEntity(
        id = id,
        title = title,
        description = description,
        state = state,
        projectId = projectId,
        tagId = tagId
    )
}
