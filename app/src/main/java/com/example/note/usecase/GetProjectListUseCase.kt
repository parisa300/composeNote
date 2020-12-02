

package com.example.note.usecase

import com.example.note.model.Note
import com.example.note.repository.NoteRepository
import kotlinx.coroutines.flow.Flow

class GetProjectListUseCase(
    private val projectRepository: NoteRepository
) {
    fun getProjectTasksList(): Flow<List<Note>> = projectRepository.projectTaskList
}
