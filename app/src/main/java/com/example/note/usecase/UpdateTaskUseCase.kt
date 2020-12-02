

package com.example.note.usecase

import com.example.note.model.Task
import com.example.note.repository.TaskRepository

class UpdateTaskUseCase(
    private val taskRepository: TaskRepository
) {
    suspend fun updateTask(task: Task) = taskRepository.updateTask(task)
}
