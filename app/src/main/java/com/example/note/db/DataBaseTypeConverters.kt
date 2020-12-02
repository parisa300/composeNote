

package com.example.note.db

import androidx.room.TypeConverter
import com.example.note.model.TaskState

class DataBaseTypeConverters {
    @TypeConverter
    fun toString(taskState: TaskState?): String? {
        return taskState?.name
    }

    @TypeConverter
    fun toTaskState(name: String): TaskState? {
        return enumValueOf<TaskState>(name)
    }
}
