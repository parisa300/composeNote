

package com.example.note.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import com.example.note.db.entity.ProjectEntity
import com.example.note.db.entity.ProjectTasks

import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {

    @Query("SELECT * FROM project WHERE id = :id")
    fun getProject(id: Int): Flow<ProjectEntity>

    @Query("SELECT * FROM project ORDER BY id ASC")
    fun getProjects(): Flow<List<ProjectEntity>>

    @Transaction
    @Query("SELECT * FROM Project")
    fun getProjectTasksList(): Flow<List<ProjectTasks>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertProject(project: ProjectEntity)

    @Update
    suspend fun updateProject(project: ProjectEntity)

    @Query("DELETE FROM project WHERE id = :id")
    suspend fun deleteProject(id: Int)
}
