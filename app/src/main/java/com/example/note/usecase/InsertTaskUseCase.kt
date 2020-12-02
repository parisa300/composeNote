

package com.example.note.usecase

import com.example.note.model.Task
import com.example.note.repository.TaskRepository

class InsertTaskUseCase(
    private val taskRepository: TaskRepository
) {
    suspend fun insertTask(task: Task) = taskRepository.insertTask(task)
}
