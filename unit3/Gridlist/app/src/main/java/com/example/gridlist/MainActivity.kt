package com.example.gridlist

import android.graphics.drawable.shapes.RoundRectShape
import android.graphics.drawable.shapes.Shape
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gridlist.data.Datasource
import com.example.gridlist.model.Topic
import com.example.gridlist.ui.theme.GridListTheme
import com.example.gridlist.ui.theme.Shapes

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GridListTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    TopicsGrid(Datasource().loadTopics())
                }
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TopicsGrid(topics: List<Topic> = Datasource().loadTopics()) {
    LazyVerticalGrid(cells = GridCells.Fixed(2), content = {
        items(topics.size) { index ->
            TopicCard(topic = topics[index])
        }
    }
    )
}

@Composable
fun TopicCard(topic: Topic) {
    Card(
        shape = RoundedCornerShape(15.dp)
    ) {
        Row() {
            Image(
                painter = painterResource(id = topic.imageResourceId),
                contentDescription = stringResource(id = topic.nameResourceId),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .weight(1f)
            )
            Box(
                modifier = Modifier
                    .weight(1.6f)
            ) {
                Column(
                    modifier = Modifier
                        .padding(top = 30.dp, end = 30.dp, bottom = 15.dp, start = 30.dp)
                ) {
                    Text(
                        text = stringResource(id = topic.nameResourceId),
                        fontSize = 30.sp,
                        modifier = Modifier
                            .padding(bottom = 15.dp)
                    )
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .align(Alignment.Start)
                    ) {
                        Icon(
                            imageVector = Icons.Default.List,
                            contentDescription = null,
                            modifier = Modifier
                                .padding(top = 2.dp, bottom = 2.dp, end = 10.dp)
                        )
                        Text(
                            text = stringResource(id = topic.coursesCountResourceId),
                            fontSize = 28.sp
                        )
                    }
                }
            }

        }
    }
}

@Preview
@Composable
fun TopicCardPreview() {
    TopicCard(Topic(R.string.name_photography, R.string.count_photography, R.drawable.photography))
}
