
package com.example.note.ui

import androidx.navigation.NavHostController
import androidx.navigation.compose.navigate
import com.example.note.ui.Destinations.AddProject
import com.example.note.ui.Destinations.AddTask
import com.example.note.ui.Destinations.EditTask

import com.example.note.ui.Destinations.TaskDetail

object Destinations {
    const val Home = "home"
    const val AddProject = "addProject"
    const val AddTask = "addTask"
    const val EditTask = "editTask"
    const val TaskDetail = "taskDetail"

    object TaskDetailArgs {
        const val TaskId = "taskId"
    }
}

class Actions(navController: NavHostController) {
    val openTask: (Int) -> Unit = { taskId ->
        navController.navigate("$TaskDetail/$taskId")
    }
    val addTask: () -> Unit = {
        navController.navigate(AddTask)
    }
    val editTask: (Int) -> Unit = { taskId ->
        navController.navigate("$EditTask/$taskId")
    }
    val addProject: () -> Unit = {
        navController.navigate(AddProject)
    }
    val navigateUp: () -> Unit = {
        navController.popBackStack()
    }
}
