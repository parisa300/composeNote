
package com.example.note.ui

import androidx.navigation.NavHostController
import androidx.navigation.compose.navigate
import com.example.note.ui.Destinations.AddProject
import com.example.note.ui.Destinations.AddTask
import com.example.note.ui.Destinations.EditTask
import com.example.note.ui.Destinations.Exit
import com.example.note.ui.Destinations.Profile

import com.example.note.ui.Destinations.TaskDetail

object Destinations {
    const val Home = "home"
    const val AddProject = "addProject"
    const val AddTask = "addTask"
    const val EditTask = "editTask"
    const val TaskDetail = "taskDetail"
    const val Profile = "profile"
    const val Exit = "exit"

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
    val profile: () -> Unit = {
        navController.navigate(Profile)
    }

    val exit: () -> Unit = {
        navController.navigate(Exit)
    }
    val navigateUp: () -> Unit = {
        navController.popBackStack()
    }
}
