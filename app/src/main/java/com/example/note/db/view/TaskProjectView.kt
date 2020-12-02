

package com.example.note.db.view

import androidx.room.ColumnInfo
import androidx.room.DatabaseView
import androidx.room.Embedded
import com.example.note.db.entity.TaskEntity


/**
 *
 */
@DatabaseView(
    "SELECT " +
        " t.*," +
        " p.name as project_name" +
        " FROM Task t LEFT JOIN Project p ON t.project_id = p.id" +
        " ORDER BY project_id"
)
data class TaskProjectView(
    @Embedded val task: TaskEntity,
    @ColumnInfo(name = "project_name") val projectName: String?
)
