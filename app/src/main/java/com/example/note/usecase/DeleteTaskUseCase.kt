

package com.example.note.usecase

import com.example.note.repository.TaskRepository

class DeleteTaskUseCase(
    private val taskRepository: TaskRepository
) {
    suspend fun deleteTask(id: Int) = taskRepository.deleteTask(id)
}
