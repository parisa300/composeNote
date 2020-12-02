
package com.example.note.db.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.note.db.view.TaskProjectView

import kotlinx.coroutines.flow.Flow

@Dao
interface TaskProjectDao {

    @Query("SELECT * FROM TaskProjectView")
    fun getTaskProjectList(): Flow<List<TaskProjectView>>
}
