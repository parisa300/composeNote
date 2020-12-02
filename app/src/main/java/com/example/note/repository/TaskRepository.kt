

package com.example.note.repository

import com.example.note.db.dao.TaskDao
import com.example.note.mapper.TaskMapper.toDomain
import com.example.note.mapper.TaskMapper.toEntity
import com.example.note.model.Task
import com.example.note.model.TaskState
import kotlinx.coroutines.flow.map

class TaskRepository(private val taskDao: TaskDao) {

    fun getTask(id: Int) = taskDao.getTask(id).map {
        it.toDomain()
    }

    suspend fun deleteTask(id: Int) = taskDao.deleteTask(id)

    suspend fun insertTask(task: Task) = taskDao.insertTask(task.toEntity())

    suspend fun updateTaskState(id: Int, taskState: TaskState) =
        taskDao.updateTaskState(id, taskState.name)

    suspend fun updateTask(task: Task) = taskDao.updateTask(task.toEntity())
}
