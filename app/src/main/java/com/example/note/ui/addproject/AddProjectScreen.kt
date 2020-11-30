
package com.example.note.ui.addproject

import android.view.MenuItem
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumnFor
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.runtime.savedinstancestate.savedInstanceState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ContextAmbient
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTag
import androidx.compose.ui.unit.dp
import com.example.note.R
import com.example.note.model.Project
import com.example.note.ui.theme.*
import com.example.note.viewmodel.MainViewModel


@Composable
fun AddProjectScreen(

    appThemeState: MutableState<AppThemeState>,
    mainViewModel: MainViewModel,
    navigateUp: () -> Unit
) {
    val showMenu = remember { mutableStateOf(false) }
    var projectName by savedInstanceState { "" }
    var projectDescription by savedInstanceState { "" }
    Scaffold(
        topBar = {
            TopAppBar(

                backgroundColor = MaterialColors.surface,
                contentColor = contentColorFor(MaterialColors.surface),
                elevation = 0.dp,
                navigationIcon = {
                    IconButton(onClick = navigateUp) {
                        Icon(Icons.Rounded.ArrowBack)
                    }
                },
                title = { Text(stringResource(id = R.string.add_project)) },
                actions = {

                    IconButton(onClick = {
                        appThemeState.value = appThemeState
                            .value.copy(darkTheme = !appThemeState.value.darkTheme)
                    }) {
                        Icon(asset = vectorResource(id = R.drawable.ic_baseline_bedtime_24))
                    }
                    IconButton(onClick = { showMenu.value = !showMenu.value }) {
                        Icon(asset = Icons.Default.MoreVert)
                    }
                },
            )
        },
        bodyContent = {
            HomeScreenContent(appThemeState.value.darkTheme, showMenu) { newPalletSelected ->
                // Events can be and should be passed to as upper layer as possible here
                // we are just passing to till HomeScreen.
                appThemeState.value = appThemeState.value.copy(pallet = newPalletSelected)
                showMenu.value = false
            }
            Column {
                OutlinedTextField(
                    value = projectName,
                    onValueChange = { projectName = it },
                    label = { Text(stringResource(id = R.string.name)) },
                    modifier = Modifier.padding(
                        start = 16.dp,
                        end = 16.dp,
                        top = 8.dp,
                        bottom = 8.dp
                    ).fillMaxWidth()
                )
                OutlinedTextField(
                    value = projectDescription,
                    onValueChange = { projectDescription = it },
                    label = { Text(stringResource(id = R.string.description)) },
                    modifier = Modifier.padding(
                        start = 16.dp,
                        end = 16.dp,
                        top = 8.dp,
                        bottom = 8.dp
                    ).fillMaxWidth().fillMaxHeight(0.6f),
                    onImeActionPerformed = { _, softwareKeyboardController -> softwareKeyboardController?.hideSoftwareKeyboard() }
                )
                Button(
                    modifier = Modifier.padding(
                        start = 16.dp,
                        end = 16.dp,
                        top = 8.dp,
                        bottom = 8.dp

                    ).fillMaxWidth(),

                    onClick = {

                        mainViewModel.insertProject(
                            Project(
                                name = projectName,
                                description = projectDescription
                            )
                        )
                        navigateUp()
                    }
                ) {
                    Icon(asset = Icons.Default.Add, modifier = Modifier.padding(end = 4.dp))
                    Text(stringResource(id = R.string.save))

                }
            }
        }

    )
}
@Composable
fun HomeScreenContent(
    isDarkTheme: Boolean,
    showMenu: MutableState<Boolean>,
    onPalletChange: (ColorPallet) -> Unit
) {
    val context = ContextAmbient.current
    //val list = remember { DemoDataProvider.homeScreenListItems }
    Box(modifier = Modifier.fillMaxSize()) {
       /* LazyColumnFor(
            modifier = Modifier.semantics { testTag = "Home Screen List of entries" },
            items = list
        ) {
          //  HomeScreenListView(it, context, isDarkTheme)
        }*/
        PalletMenu(
            modifier = Modifier.align(Alignment.TopEnd),
            showMenu.value,
            onPalletChange
        )
    }
}

@Composable
fun PalletMenu(
    modifier: Modifier,
    showMenu: Boolean,
    onPalletChange: (ColorPallet) -> Unit
) {
    Card(
        modifier = modifier.padding(8.dp)
            .animateContentSize(),
        elevation = 8.dp
    ) {
        Column(
            horizontalAlignment = Alignment.Start
        ) {
            if (showMenu) {
                MenuItem(green, "Green") {
                    onPalletChange.invoke(ColorPallet.GREEN)
                }
                MenuItem(purple, "Purple") {
                    onPalletChange.invoke(ColorPallet.PURPLE)
                }
                MenuItem(orange, "Orange") {
                    onPalletChange.invoke(ColorPallet.ORANGE)
                }
                MenuItem(blue, "Blue") {
                    onPalletChange.invoke(ColorPallet.BLUE)
                }
            } else {

            }
        }
    }
}

@Composable
fun MenuItem(color: Color, name: String, onPalletChange: () -> Unit) {
    Row(
        modifier = Modifier.padding(8.dp).clickable(onClick = onPalletChange),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(asset = Icons.Filled.FavoriteBorder, tint = color)
        Text(text = name, modifier = Modifier.padding(8.dp))
    }
}