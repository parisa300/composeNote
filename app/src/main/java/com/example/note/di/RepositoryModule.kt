
package com.example.note.di

import com.example.note.db.dao.NoteDao
import com.example.note.db.dao.TaskDao
import com.example.note.db.dao.TaskProjectDao
import com.example.note.repository.NoteRepository
import com.example.note.repository.TaskProjectRepository
import com.example.note.repository.TaskRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.scopes.ActivityRetainedScoped

@Module
@InstallIn(ActivityRetainedComponent::class)
class RepositoryModule {

    @Provides
    @ActivityRetainedScoped
    fun provideTaskRepository(taskDao: TaskDao) = TaskRepository(taskDao)

    @Provides
    @ActivityRetainedScoped
    fun provideProjectRepository(projectDao: NoteDao) = NoteRepository(projectDao)

    @Provides
    @ActivityRetainedScoped
    fun provideTaskProjectRepository(taskProjectDao: TaskProjectDao) = TaskProjectRepository(taskProjectDao)
}
