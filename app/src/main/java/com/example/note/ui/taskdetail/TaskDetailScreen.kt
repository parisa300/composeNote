
package com.example.note.ui.taskdetail

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.ScrollableColumn
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.AmbientEmphasisLevels
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.ProvideEmphasis
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.contentColorFor
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.Edit
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import com.example.note.R
import com.example.note.model.Task
import com.example.note.ui.components.HorizontalDivider
import com.example.note.ui.theme.MaterialColors
import com.example.note.ui.theme.MaterialTypography
import com.example.note.viewmodel.MainViewModel

@Composable
fun TaskDetailScreen(
    taskId: Int,
    mainViewModel: MainViewModel,
    editTask: (Int) -> Unit,
    navigateUp: () -> Unit
) {
    val scrollState = rememberScrollState(0f)
    val taskState = mainViewModel.getTask(taskId).observeAsState()
    taskState.value?.let { task ->
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        if (scrollState.value >= 120) {
                            Text(task.title)
                        }
                    },
                    navigationIcon = {
                        IconButton(onClick = navigateUp) {
                            Icon(Icons.Rounded.ArrowBack)
                        }
                    },
                    elevation = 0.dp,
                    backgroundColor = MaterialColors.surface,
                    contentColor = contentColorFor(color = MaterialColors.surface)
                )
            },
            bodyContent = {
                TaskDetailBody(scrollState, task)
            },
            floatingActionButton = {
                FloatingActionButton(
                    onClick = {
                        editTask(taskId)
                    },
                    icon = {
                        Icon(Icons.Rounded.Edit)
                    }
                )
            }
        )
    }
}

@Composable
fun TaskDetailBody(scrollState: ScrollState, task: Task) {
    Column {
        if (scrollState.value >= 270) {
            HorizontalDivider()
        }
        ScrollableColumn(scrollState = scrollState) {
            Text(
                text = task.title,
                style = MaterialTypography.h4,
                modifier = Modifier.padding(32.dp),
                maxLines = 1
            )
            HorizontalDivider()
            if (task.description.isNotBlank()) {
                Text(
                    text = task.description,
                    style = MaterialTypography.body1,
                    modifier = Modifier.padding(24.dp)
                )
            } else {
                ProvideEmphasis(emphasis = AmbientEmphasisLevels.current.medium) {
                    Text(
                        text = stringResource(id = R.string.no_description),
                        style = MaterialTypography.body1,
                        fontStyle = FontStyle.Italic,
                        modifier = Modifier.padding(24.dp)
                    )
                }
            }
        }
    }
}
