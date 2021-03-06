package com.example.note.ui.addnote.profile

import androidx.compose.animation.animate
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawOpacity
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTag
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.note.R
import com.example.note.ui.theme.gradientBluePurple
import com.example.note.ui.theme.typography
import com.example.note.ui.utils.horizontalGradientBackground
import com.example.note.viewmodel.MainViewModel


private val initialimageFloat = 170f


//NOTE: This stuff should usually be in a parent activity/Navigator
// We can pass callback to profileScreen to get the click.


@Composable
fun ProfileScreen( mainViewModel: MainViewModel,
                   navigateUp: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .semantics { testTag = "Profile Screen" }
    ) {
        val scrollState = rememberScrollState(0f)
        TopAppBarView(scrollState.value)
        TopBackground()
        ScrollableColumn(scrollState = scrollState, modifier = Modifier.fillMaxSize()) {
            Spacer(modifier = Modifier.height(100.dp))
            TopScrollingContent(scrollState)
            BottomScrollingContent()
        }
    }
}

@Composable
fun TopScrollingContent(scrollState: ScrollState) {
    val visibilityChangeFloat = scrollState.value > initialimageFloat - 20
    Row {
        AnimatedImage(scroll = scrollState.value)
        Column(
            modifier = Modifier.padding(start = 8.dp, top = 48.dp)
                .drawOpacity(animate(if (visibilityChangeFloat) 0f else 1f))
        ) {
            Text(
                text = "parisa mahmoodi",
                style = typography.h6.copy(fontSize = 18.sp),
                modifier = Modifier.padding(bottom = 4.dp)
            )
            Text(
                text = "Android developer ",
                style = typography.subtitle2
            )
        }
    }
}

@Composable
fun BottomScrollingContent() {
    Column(modifier = Modifier.background(MaterialTheme.colors.surface).padding(8.dp)) {

        Text(
            text = "About Me",
            style = typography.h6,
            modifier = Modifier.padding(start = 8.dp, top = 12.dp)
        )
        Divider(modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp))
        Text(
            text = stringResource(id = R.string.about_me),
            style = typography.body1,
            modifier = Modifier.fillMaxWidth().padding(8.dp),
        )
        InterestsSection()
        MyPhotosSection()

        Text(
            text = "About Project",
            style = typography.h6,
            modifier = Modifier.padding(start = 8.dp, top = 16.dp)
        )
        Divider(modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp))
        Text(
            text = stringResource(id = R.string.about_project),
            style = typography.body1,
            modifier = Modifier.fillMaxWidth().padding(8.dp),
        )

    }
}

@Composable
fun MyPhotosSection() {
    Text(
            text = "My Gallery",
            style = typography.h6,
            modifier = Modifier.padding(start = 8.dp, top = 16.dp)
    )
    Divider(modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp))
    val imageModifier = Modifier
            .padding(vertical = 8.dp, horizontal = 4.dp)
            .preferredSize(120.dp)
            .clip(RoundedCornerShape(8.dp))

    Row(
            modifier = Modifier.padding(start = 8.dp, top = 8.dp).fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Image(
                asset = imageResource(id = R.drawable.one),

                modifier = imageModifier,
                contentScale = ContentScale.Crop
        )
        Image(
                asset = imageResource(id = R.drawable.image2),
                modifier = imageModifier,
                contentScale = ContentScale.Crop
        )
        Image(
                asset = imageResource(id = R.drawable.image3),
                modifier = imageModifier,
                contentScale = ContentScale.Crop
        )
    }
    Row(
            modifier = Modifier.padding(start = 8.dp, top = 8.dp).fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Image(
                asset = imageResource(id = R.drawable.image4),
                modifier = imageModifier,
                contentScale = ContentScale.Crop
        )
        Image(
                asset = imageResource(id = R.drawable.image5),
                modifier = imageModifier,
                contentScale = ContentScale.Crop
        )
        Image(
                asset = imageResource(id = R.drawable.image2),
                modifier = imageModifier,
                contentScale = ContentScale.Crop
        )
    }
}


@Composable
fun InterestsSection() {
    Text(
        text = "My Interests",
        style = typography.h6,
        modifier = Modifier.padding(start = 8.dp, top = 16.dp)
    )
    Divider(modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp))
    Row(modifier = Modifier.padding(start = 8.dp, top = 8.dp)) {
        InterestTag("Android")
        InterestTag("Compose")
        InterestTag("Navigate")
        InterestTag("Room")

    }
    Row(modifier = Modifier.padding(start = 8.dp)) {

        InterestTag("Podcasts")

    }
}

@Composable
fun TopAppBarView(scroll: Float) {
    if (scroll > initialimageFloat + 5) {
        TopAppBar(
            title = {
                Text(text = "parisa ")
            },
            navigationIcon = {
                Image(
                    asset = imageResource(id = R.drawable.p1),
                    modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
                        .preferredSize(32.dp).clip(CircleShape)
                )
            },
            actions = {
                Icon(
                    asset = Icons.Default.Settings,
                    modifier = Modifier.padding(horizontal = 8.dp)
                )
            }
        )
    }
}


@Composable
fun AnimatedImage(scroll: Float) {
    val dynamicAnimationSizeValue = (initialimageFloat - scroll).coerceIn(36f, initialimageFloat)
    Image(
        asset = imageResource(id = R.drawable.p1),
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .padding(start = 16.dp)
            .preferredSize(animate(Dp(dynamicAnimationSizeValue)))
            .clip(CircleShape)
    )
}

@Composable
private fun TopBackground() {
    Spacer(
        modifier = Modifier
            .preferredHeight(150.dp)
            .fillMaxWidth()
            .horizontalGradientBackground(gradientBluePurple)
    )
}



