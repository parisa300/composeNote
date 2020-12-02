

package com.example.note.usecase

import com.example.note.model.TaskState
import com.example.note.repository.TaskRepository

class UpdateTaskStateUseCase(
    private val taskRepository: TaskRepository
) {
    suspend fun updateTaskState(id: Int, taskState: TaskState) = taskRepository.updateTaskState(id, taskState)
}
