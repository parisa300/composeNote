

package com.example.note.mapper

import com.example.note.db.view.TaskProjectView
import com.example.note.model.TaskProject


object TaskProjectMapper {

    fun TaskProjectView.toDomain() = TaskProject(
        id = task.id,
        title = task.title,
        description = task.description,
        state = task.state,
        tagId = task.tagId,
        projectId = task.projectId,
        projectName = projectName
    )
}
