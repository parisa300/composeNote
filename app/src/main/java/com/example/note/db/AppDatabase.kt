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

package com.example.note.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.note.db.dao.ProjectDao
import com.example.note.db.dao.TagDao
import com.example.note.db.dao.TaskDao
import com.example.note.db.dao.TaskProjectDao
import com.example.note.db.entity.ProjectEntity
import com.example.note.db.entity.TagEntity
import com.example.note.db.entity.TaskEntity
import com.example.note.db.view.TaskProjectView

@Database(
    entities = [ProjectEntity::class, TagEntity::class, TaskEntity::class],
    views = [TaskProjectView::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(DataBaseTypeConverters::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun projectDao(): ProjectDao

    abstract fun tagDao(): TagDao

    abstract fun taskDao(): TaskDao

    abstract fun taskProjectDao(): TaskProjectDao
}
