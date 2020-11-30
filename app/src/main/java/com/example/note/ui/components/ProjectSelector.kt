

package com.example.note.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.preferredHeight
import androidx.compose.foundation.lazy.LazyColumnFor
import androidx.compose.foundation.selection.selectable
import androidx.compose.material.MaterialTheme
import androidx.compose.material.RadioButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.note.R
import com.example.note.model.Project
import java.util.Locale

@Composable
fun ProjectSelector(
    projectList: List<Project>,
    selectedProject: Project,
    onProjectSelected: (project: Project) -> Unit
) {
    Column {
        Text(
            text = stringResource(R.string.project).toUpperCase(Locale.ROOT),
            style = MaterialTheme.typography.overline,
            modifier = Modifier.padding(start = 16.dp, top = 16.dp)
        )
        HorizontalDivider(modifier = Modifier.padding(top = 8.dp))
        LazyColumnFor(
            items = projectList,
            modifier = Modifier.height(140.dp)
        ) { project ->
            Row(
                Modifier
                    .fillMaxWidth()
                    .preferredHeight(56.dp)
                    .selectable(
                        selected = (project == selectedProject),
                        onClick = { onProjectSelected(project) }
                    )
                    .padding(horizontal = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(
                    selected = (project == selectedProject),
                    onClick = { onProjectSelected(project) }
                )
                Text(
                    text = project.name,
                    style = MaterialTheme.typography.body1.merge(),
                    modifier = Modifier.padding(start = 16.dp)
                )
            }
        }
        HorizontalDivider()
    }
}
