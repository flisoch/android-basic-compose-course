package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Lemonade()
                }
            }
        }
    }
}

enum class Stage {
    TREE, SQUEEZE, DRINK, RESTART
}

fun nextStage(stage: Stage = Stage.RESTART): Stage {
    return when (stage) {
        Stage.TREE -> Stage.SQUEEZE
        Stage.SQUEEZE -> Stage.DRINK
        Stage.DRINK -> Stage.RESTART
        Stage.RESTART -> Stage.TREE
    }
}

@Preview
@Composable
fun LemonadePreview() {
    LemonadeTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            Lemonade()
        }
    }
}

@Composable
fun Lemonade() {
    var stage by remember { mutableStateOf(nextStage()) }
    val imageResourceId: Int
    val text: String
    val imageDescription: String
    var squeezeCount = 0
    val squeezesNeed: Int = (2..4).random()
    when (stage) {
        Stage.TREE -> {
            imageResourceId = R.drawable.lemon_tree
            text = stringResource(R.string.lemon_tree)
            imageDescription = stringResource(R.string.description_tree)
        }
        Stage.SQUEEZE -> {
            imageResourceId = R.drawable.lemon_squeeze
            text = stringResource(R.string.lemon_squeeze)
            imageDescription = stringResource(R.string.description_squeeze)
        }
        Stage.DRINK -> {
            imageResourceId = R.drawable.lemon_drink
            text = stringResource(R.string.lemon_drink)
            imageDescription = stringResource(R.string.description_drink)
        }
        Stage.RESTART -> {
            imageResourceId = R.drawable.lemon_restart
            text = stringResource(R.string.lemon_restart)
            imageDescription = stringResource(R.string.description_restart)
        }
    }

    SqueezingStageScreen(
        image = imageResourceId,
        imageDescription = imageDescription,
        text = text,
        onImageClick = {
            if (stage == Stage.SQUEEZE) {
                if (squeezeCount == squeezesNeed) {
                    squeezeCount = 0
                    stage = nextStage(stage)
                } else {
                    squeezeCount++
                }
            } else {
                stage = nextStage(stage)
            }
        },
        modifier = Modifier.wrapContentSize(Alignment.Center)
    )
}


@Composable
fun SqueezingStageScreen(
    image: Int,
    imageDescription: String,
    text: String,
    onImageClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(modifier = modifier) {
        Text(
            text = text,
            fontSize = 18.sp,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(bottom = 16.dp)
        )

        Button(
            onClick = onImageClick,
            border = BorderStroke(2.dp, Color(105, 205, 216)),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Transparent,
                disabledBackgroundColor = Color.Transparent,
            ),
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Image(painter = painterResource(id = image), imageDescription)
        }
    }
}