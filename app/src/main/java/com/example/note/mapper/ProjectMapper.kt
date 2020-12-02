

package com.example.note.mapper


import com.example.note.db.entity.ProjectEntity
import com.example.note.db.entity.ProjectTasks
import com.example.note.model.Note
import com.example.note.mapper.TaskMapper.toDomain


object ProjectMapper {
    fun ProjectTasks.toDomain() = Note(
        project.id, project.name, project.description, tasks.map { it.toDomain() }
    )

    fun Note.toEntity() = ProjectEntity(
        name, description
    )
}
