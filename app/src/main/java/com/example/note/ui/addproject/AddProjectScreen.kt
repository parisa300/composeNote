
package com.example.note.ui.addproject

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.contentColorFor
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.savedinstancestate.savedInstanceState
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.note.R
import com.example.note.model.Project
import com.example.note.viewmodel.MainViewModel

import com.example.note.ui.theme.MaterialColors


@Composable
fun AddProjectScreen(
    mainViewModel: MainViewModel,
    navigateUp: () -> Unit
) {
    var projectName by savedInstanceState { "" }
    var projectDescription by savedInstanceState { "" }
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
                title = { Text(stringResource(id = R.string.add_project)) },
                actions = {

                }
            )
        },
        bodyContent = {
            Column {
                OutlinedTextField(
                    value = projectName,
                    onValueChange = { projectName = it },
                    label = { Text(stringResource(id = R.string.name)) },
                    modifier = Modifier.padding(
                        start = 16.dp,
                        end = 16.dp,
                        top = 8.dp,
                        bottom = 8.dp
                    ).fillMaxWidth()
                )
                OutlinedTextField(
                    value = projectDescription,
                    onValueChange = { projectDescription = it },
                    label = { Text(stringResource(id = R.string.description)) },
                    modifier = Modifier.padding(
                        start = 16.dp,
                        end = 16.dp,
                        top = 8.dp,
                        bottom = 8.dp
                    ).fillMaxWidth().fillMaxHeight(0.6f),
                    onImeActionPerformed = { _, softwareKeyboardController -> softwareKeyboardController?.hideSoftwareKeyboard() }
                )
                Button(
                    modifier = Modifier.padding(
                        start = 16.dp,
                        end = 16.dp,
                        top = 8.dp,
                        bottom = 8.dp
                    ).fillMaxWidth(),
                    onClick = {
                        mainViewModel.insertProject(
                            Project(
                                name = projectName,
                                description = projectDescription
                            )
                        )
                        navigateUp()
                    }
                ) {
                    Text(stringResource(id = R.string.save))

                }
            }
        }
    )
}
