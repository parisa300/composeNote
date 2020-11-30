

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
import com.example.note.model.TaskState
import com.example.note.ui.components.ProjectSelector
import com.example.note.ui.components.TextField
import com.example.note.ui.theme.MaterialColors
import com.example.note.viewmodel.MainViewModel

@Composable
fun AddTaskScreen(
    mainViewModel: MainViewModel,
    navigateUp: () -> Unit
) {
    var taskTitle by savedInstanceState { "" }
    val taskTitleInputError = remember { mutableStateOf(false) }
    var taskDescription by savedInstanceState { "" }
    val radioOptions = mainViewModel.projectList
    val (selectedProject, onProjectSelected) = remember { mutableStateOf(radioOptions[0]) }
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
                title = { Text(stringResource(id = R.string.add_task)) }
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
                        mainViewModel.insertTask(
                            Task(
                                title = taskTitle,
                                description = taskDescription,
                                state = TaskState.DOING,
                                projectId = selectedProject.id,
                                tagId = null
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
