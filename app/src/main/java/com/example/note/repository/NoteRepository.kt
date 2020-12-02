

package com.example.note.repository

import com.example.note.db.dao.NoteDao
import com.example.note.mapper.ProjectMapper.toDomain
import com.example.note.mapper.ProjectMapper.toEntity
import com.example.note.model.Note
import kotlinx.coroutines.flow.map

class NoteRepository(private val projectDao: NoteDao) {

    val projectTaskList = projectDao.getProjectTasksList().map { list ->
        list.map { it.toDomain() }
    }

    suspend fun deleteNote(id: Int) = projectDao.deleteProject(id)

    suspend fun insertNote(project: Note) = projectDao.insertProject(project.toEntity())
}
