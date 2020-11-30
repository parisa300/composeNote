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

package com.example.note.di

import com.example.note.repository.ProjectRepository
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
    fun provideInsertProjectUseCase(projectRepository: ProjectRepository) = InsertProjectUseCase(projectRepository)

    @Provides
    @ActivityRetainedScoped
    fun provideGetProjectTasksListUseCase(projectRepository: ProjectRepository) = GetProjectListUseCase(projectRepository)
}
