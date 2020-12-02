

package com.example.note.usecase

import com.example.note.model.Task
import com.example.note.repository.TaskRepository
import kotlinx.coroutines.flow.Flow

class GetTaskUseCase(val taskRepository: TaskRepository) {
    fun getTask(id: Int): Flow<Task> = taskRepository.getTask(id)
}
