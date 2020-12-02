

package com.example.note.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.note.model.Note
import com.example.note.model.Task
import com.example.note.model.TaskState
import com.example.note.usecase.DeleteTaskUseCase
import com.example.note.usecase.GetProjectListUseCase
import com.example.note.usecase.GetTaskUseCase
import com.example.note.usecase.InsertProjectUseCase
import com.example.note.usecase.InsertTaskUseCase
import com.example.note.usecase.UpdateTaskStateUseCase
import com.example.note.usecase.UpdateTaskUseCase
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MainViewModel @ViewModelInject constructor(
    @Assisted private val savedStateHandle: SavedStateHandle,
    private val getTaskUseCase: GetTaskUseCase,
    private val insertTaskUseCase: InsertTaskUseCase,
    private val insertProjectUseCase: InsertProjectUseCase,
    private val getProjectListUseCase: GetProjectListUseCase,
    private val updateTaskUseCase: UpdateTaskUseCase,
    private val updateTaskStateUseCase: UpdateTaskStateUseCase,
    private val deleteTaskUseCase: DeleteTaskUseCase
) : ViewModel() {

    var projectList: List<Note> by mutableStateOf(listOf())
        private set

    init {
        viewModelScope.launch {
            getProjectListUseCase.getProjectTasksList().collect {
                projectList = it
            }
        }
    }

    val updateTaskState: (Int, TaskState) -> Unit = { id, taskState -> updateTaskState(id, taskState) }

    fun insertTask(task: Task) = viewModelScope.launch {
        insertTaskUseCase.insertTask(task)
    }

    fun insertProject(project: Note) = viewModelScope.launch {
        insertProjectUseCase.insertProject(project)
    }

    private fun updateTaskState(id: Int, taskState: TaskState) = viewModelScope.launch {
        updateTaskStateUseCase.updateTaskState(id, taskState)
    }

    fun getTask(id: Int) = getTaskUseCase.getTask(id).asLiveData()

    fun deleteTask(id: Int) = viewModelScope.launch {
        deleteTaskUseCase.deleteTask(id)
    }

    fun updateTask(task: Task) = viewModelScope.launch {
        updateTaskUseCase.updateTask(task)
    }
}
