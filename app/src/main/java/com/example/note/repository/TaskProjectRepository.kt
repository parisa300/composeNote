

package com.example.note.repository

import com.example.note.db.dao.TaskProjectDao
import com.example.note.mapper.TaskProjectMapper.toDomain
import com.example.note.model.TaskProject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class TaskProjectRepository(private val taskProjectDao: TaskProjectDao) {

    val taskProjectList: Flow<List<TaskProject>> = taskProjectDao.getTaskProjectList().map { list ->
        list.map { it.toDomain() }
    }
}
