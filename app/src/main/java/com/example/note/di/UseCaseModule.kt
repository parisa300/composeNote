

package com.example.note.di

import com.example.note.repository.NoteRepository
import com.example.note.repository.TaskRepository
import com.example.note.usecase.DeleteTaskUseCase
import com.example.note.usecase.GetProjectListUseCase
import com.example.note.usecase.GetTaskUseCase
import com.example.note.usecase.InsertProjectUseCase
import com.example.note.usecase.InsertTaskUseCase
import com.example.note.usecase.UpdateTaskStateUseCase
import com.example.note.usecase.UpdateTaskUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.scopes.ActivityRetainedScoped

@Module
@InstallIn(ActivityRetainedComponent::class)
class UseCaseModule {

    @Provides
    @ActivityRetainedScoped
    fun provideGetTaskUseCase(taskRepository: TaskRepository) = GetTaskUseCase(taskRepository)

    @Provides
    @ActivityRetainedScoped
    fun provideUpdateTaskStateUseCase(taskRepository: TaskRepository) = UpdateTaskStateUseCase(taskRepository)

    @Provides
    @ActivityRetainedScoped
    fun provideUpdateTaskUseCase(taskRepository: TaskRepository) = UpdateTaskUseCase(taskRepository)

    @Provides
    @ActivityRetainedScoped
    fun provideInsertTaskUseCase(taskRepository: TaskRepository) = InsertTaskUseCase(taskRepository)

    @Provides
    @ActivityRetainedScoped
    fun provideDeleteTaskUseCase(taskRepository: TaskRepository) = DeleteTaskUseCase(taskRepository)

    @Provides
    @ActivityRetainedScoped
    fun provideInsertProjectUseCase(projectRepository: NoteRepository) = InsertProjectUseCase(projectRepository)

    @Provides
    @ActivityRetainedScoped
    fun provideGetProjectTasksListUseCase(projectRepository: NoteRepository) = GetProjectListUseCase(projectRepository)
}
