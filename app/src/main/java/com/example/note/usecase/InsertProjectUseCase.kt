

package com.example.note.usecase

import com.example.note.model.Note
import com.example.note.repository.NoteRepository

class InsertProjectUseCase(
    private val projectRepository: NoteRepository
) {
    suspend fun insertProject(project: Note) = projectRepository.insertNote(project)
}
