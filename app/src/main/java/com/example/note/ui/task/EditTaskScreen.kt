

package com.example.note.ui.task

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.contentColorFor
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.Check
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.savedinstancestate.savedInstanceState
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.unit.dp
import com.example.note.R
import com.example.note.model.Task
import com.example.note.ui.components.ProjectSelector
import com.example.note.ui.components.TextField
import com.example.note.ui.theme.MaterialColors
import com.example.note.viewmodel.MainViewModel

@Composable
fun EditTaskScreen(
    taskId: Int,
    mainViewModel: MainViewModel,
    navigateUp: () -> Unit
) {
    val taskState = mainViewModel.getTask(taskId).observeAsState()
    taskState.value?.let { task ->
        var taskTitle by savedInstanceState { task.title }
        val taskTitleInputError = remember { mutableStateOf(false) }
        var taskDescription by savedInstanceState { task.description }
        val radioOptions = mainViewModel.projectList
        val projectIndex =
            radioOptions.indexOfFirst { it.id == task.projectId }.takeUnless { it == -1 } ?: 0
        val (selectedProject, onProjectSelected) = remember { mutableStateOf(radioOptions[projectIndex]) }
        Scaffold(
            topBar = {
                TopAppBar(
                    backgroundColor = MaterialColors.surface,
                    contentColor = contentColorFor(MaterialColors.surface),
                    elevation = 0.dp,
                    navigationIcon = {
                        IconButton(onClick = navigateUp) {
                            Icon(Icons.Rounded.ArrowBack)
                        }
                    },
                    title = { Text(stringResource(id = R.string.edit_task)) }
                )
            },
            bodyContent = {
                Column {
                    TextField(
                        value = taskTitle,
                        onValueChanged = {
                            taskTitle = it
                            taskTitleInputError.value = false
                        },
                        label = { Text(stringResource(id = R.string.title)) },
                        isErrorValue = taskTitleInputError.value,
                        errorMessage = stringResource(id = R.string.field_not_empty),
                        keyboardOptions = KeyboardOptions(
                            capitalization = KeyboardCapitalization.Sentences,
                            imeAction = ImeAction.Next
                        )
                    )
                    TextField(
                        value = taskDescription,
                        onValueChanged = { taskDescription = it },
                        label = { Text(stringResource(id = R.string.description)) },
                        onImeActionPerformed = { _, softwareKeyboardController -> softwareKeyboardController?.hideSoftwareKeyboard() },
                        keyboardOptions = KeyboardOptions(
                            capitalization = KeyboardCapitalization.Sentences,
                            imeAction = ImeAction.Done
                        )
                    )
                    ProjectSelector(radioOptions, selectedProject, onProjectSelected)
                }
            },
            floatingActionButton = {
                FloatingActionButton(
                    onClick = {
                        if (taskTitle.isBlank()) {
                            taskTitleInputError.value = true
                        } else {
                            mainViewModel.updateTask(
                                Task(
                                    id = task.id,
                                    title = taskTitle,
                                    description = taskDescription,
                                    state = task.state,
                                    projectId = selectedProject.id,
                                    tagId = task.tagId
                                )
                            )
                            navigateUp()
                        }
                    },
                    icon = { Icon(Icons.Rounded.Check) }
                )
            }
        )
    }
}
