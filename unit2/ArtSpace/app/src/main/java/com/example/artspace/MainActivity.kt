package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ArtworkScreen()
                }
            }
        }
    }
}

@Preview(device = "id:pixel_c")
@Composable
fun Preview() {
    ArtSpaceTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            ArtworkScreen()
        }
    }
}


@Composable
fun ArtworkScreen() {
    var imageNumber by remember { mutableStateOf(1) }
    val imagesCount = 6

    val authorStringResource: Int
    val imageTitleStringResource: Int
    val imageResource: Int

    when (imageNumber) {
        1 -> {
            authorStringResource = R.string.author_1
            imageResource = R.drawable.image_1
            imageTitleStringResource = R.string.title_1
        }
        2 -> {
            authorStringResource = R.string.author_2
            imageResource = R.drawable.image_2
            imageTitleStringResource = R.string.title_2
        }
        3 -> {
            authorStringResource = R.string.author_3
            imageResource = R.drawable.image_3
            imageTitleStringResource = R.string.title_3
        }
        4 -> {
            authorStringResource = R.string.author_4
            imageResource = R.drawable.image_4
            imageTitleStringResource = R.string.title_4
        }
        5 -> {
            authorStringResource = R.string.author_5
            imageResource = R.drawable.image_5
            imageTitleStringResource = R.string.title_5
        }
        else -> {
            authorStringResource = R.string.author_6
            imageResource = R.drawable.image_6
            imageTitleStringResource = R.string.title_6
        }
    }


    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(start = 20.dp, end = 20.dp, top = 10.dp, bottom = 10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        ArtImage(imageResource, Modifier.weight(1f, fill = true))
        Spacer(modifier = Modifier.height(20.dp))
        ArtTitle(imageTitleStringResource, authorStringResource)
        Spacer(modifier = Modifier.height(20.dp))
        ControlButtons(
            onNext = {
                imageNumber = nextArtwork(imageNumber, imagesCount)
            },
            onPrevious = {
                imageNumber = prevArtwork(imageNumber, imagesCount)

            }
        )

    }
}

@Composable
fun ControlButtons(onNext: () -> Unit, onPrevious: () -> Unit) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxWidth()
    ) {
        Button(
            onClick = onPrevious, modifier = Modifier
                .padding(start = 20.dp, top = 5.dp, bottom = 5.dp, end = 10.dp)
                .width(150.dp)
        ) {
            Text(text = stringResource(R.string.button_text_previous))
        }
        Button(
            onClick = onNext, modifier = Modifier
                .padding(start = 10.dp, top = 5.dp, bottom = 5.dp, end = 20.dp)
                .width(150.dp)
        ) {
            Text(text = stringResource(R.string.button_text_next))
        }

    }
}

@Composable
fun ArtTitle(imageTitleStringResource: Int, authorStringResource: Int) {
    Box(
        modifier = Modifier
            .shadow(elevation = 2.dp)
            .padding(all = 15.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center,
        ) {
            Text(
                text = stringResource(id = imageTitleStringResource),
                fontSize = 18.sp
            )
            Text(
                text = stringResource(id = authorStringResource),
                fontWeight = FontWeight.Bold,
            )
        }
    }
}

@Composable
fun ArtImage(imageResource: Int, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
    ) {
        Box(
            modifier = Modifier
                .border(
                    border = BorderStroke(2.dp, Color.Gray),
                    shape = RectangleShape
                )
                .padding(all = 30.dp)
                .align(Alignment.Center)
        ) {
            Image(
                painter = painterResource(id = imageResource),
                contentDescription = "image",
                alignment = Alignment.Center
            )
        }
    }
}

fun nextArtwork(number: Int, max: Int): Int {
    return if (number == max) 1 else number + 1
}

fun prevArtwork(number: Int, max: Int): Int {
    return if (number == 1) max else number - 1
}