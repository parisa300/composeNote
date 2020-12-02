

package com.example.note.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.note.db.dao.NoteDao
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

    abstract fun projectDao(): NoteDao

    abstract fun tagDao(): TagDao

    abstract fun taskDao(): TaskDao

    abstract fun taskProjectDao(): TaskProjectDao
}
