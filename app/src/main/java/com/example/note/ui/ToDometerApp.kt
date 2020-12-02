

package com.example.note.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import com.example.note.viewmodel.MainViewModel
import com.example.note.ui.Destinations.AddProject
import com.example.note.ui.Destinations.AddTask
import com.example.note.ui.Destinations.EditTask
import com.example.note.ui.Destinations.Exit
import com.example.note.ui.Destinations.Home
import com.example.note.ui.Destinations.Profile
import com.example.note.ui.Destinations.TaskDetail
import com.example.note.ui.Destinations.TaskDetailArgs.TaskId
import com.example.note.ui.addnote.AddNoteScreen
import com.example.note.ui.addnote.profile.ProfileScreen
import com.example.note.ui.home.Exitaccunt
import com.example.note.ui.home.HomeScreen
import com.example.note.ui.task.AddTaskScreen
import com.example.note.ui.task.EditTaskScreen
import com.example.note.ui.taskdetail.TaskDetailScreen
import com.example.note.ui.theme.AppThemeState
import com.example.note.ui.theme.ToDometerTheme


@Composable
fun ToDometerApp(mainViewModel: MainViewModel) {

    val navController = rememberNavController()
    val actions = remember(navController) { Actions(navController) }
    ToDometerTheme {
        NavHost(navController = navController, startDestination = Home) {
            composable(Home) {
                HomeScreen(
                    mainViewModel = mainViewModel,
                    addTask = actions.addTask,
                    exit = actions.exit,
                    addProject = actions.addProject,
                    openTask = actions.openTask,
                    profile = actions.profile
                )
            }
            composable(
                "$TaskDetail/{$TaskId}",
                arguments = listOf(navArgument(TaskId) { type = NavType.IntType })
            ) { backStackEntry ->
                TaskDetailScreen(
                    taskId = backStackEntry.arguments?.getInt(TaskId) ?: 0,
                    mainViewModel = mainViewModel,
                    editTask = actions.editTask,
                    navigateUp = actions.navigateUp
                )
            }
            composable(AddProject) {
                AddNoteScreen(
                    appThemeState = mutableStateOf(AppThemeState()),
                    mainViewModel = mainViewModel,
                    navigateUp = actions.navigateUp
                )
            }
            composable(Profile) {
                ProfileScreen(

                    mainViewModel = mainViewModel,
                    navigateUp = actions.navigateUp
                )
            }
            composable(AddTask) {
                AddTaskScreen(
                    mainViewModel = mainViewModel,
                    navigateUp = actions.navigateUp
                )
            }

            composable(Exit) {
                Exitaccunt(
                    mainViewModel = mainViewModel,
                    navigateUp = actions.navigateUp,

                )
            }
            composable(
                "$EditTask/{$TaskId}",
                arguments = listOf(navArgument(TaskId) { type = NavType.IntType })
            ) { backStackEntry ->
                EditTaskScreen(
                    taskId = backStackEntry.arguments?.getInt(TaskId) ?: 0,
                    mainViewModel = mainViewModel,
                    navigateUp = actions.navigateUp
                )
            }
        }
    }
}
