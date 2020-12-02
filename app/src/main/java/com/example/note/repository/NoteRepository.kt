/*
 * Copyright 2020 Sergio Belda
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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
