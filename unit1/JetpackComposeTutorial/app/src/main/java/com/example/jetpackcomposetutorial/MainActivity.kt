package com.example.jetpackcomposetutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposetutorial.ui.theme.JetpackComposeTutorialTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeTutorialTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Article()
                }
            }
        }
    }
}

@Composable
fun Article() {
    Column {
        HeaderImage()
        Title()
        About()
        ArticleText()
    }
}

@Composable
fun Title() {
    Text(
        text = stringResource(R.string.title),
        fontSize = 24.sp,
        modifier = Modifier
            .padding(all = 16.dp)
    )
}

@Composable
fun About() {
    Text(
        text = stringResource(R.string.about),
        textAlign = TextAlign.Justify,
        modifier = Modifier
            .padding(start = 16.dp, end = 16.dp)
        )
}

@Composable
fun ArticleText() {
    Text(
        text = stringResource(R.string.article_text),
        textAlign = TextAlign.Justify,
        modifier = Modifier
            .padding(all = 16.dp)
    )
}

@Composable
fun HeaderImage() {
    val image = painterResource(R.drawable.bg_compose_background)
    Image(
        painter = image,
        contentDescription = null,
        modifier = Modifier
            .fillMaxWidth()
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackComposeTutorialTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            Article()
        }
    }
}