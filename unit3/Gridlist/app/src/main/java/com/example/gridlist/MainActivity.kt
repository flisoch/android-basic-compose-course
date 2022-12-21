package com.example.gridlist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.gridlist.data.Datasource
import com.example.gridlist.model.Topic
import com.example.gridlist.ui.theme.GridListTheme

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
                    TopicsGrid(topics = Datasource().loadTopics())
                }
            }
        }
    }
}

@Composable
fun TopicsGrid(modifier: Modifier = Modifier, topics: List<Topic> = Datasource().loadTopics()) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier.padding(8.dp)
    ) {
        items(topics) { topic ->
            TopicCard(topic)
        }
    }
}

@Composable
fun TopicCard(topic: Topic, modifier: Modifier = Modifier) {
    Card(
        elevation = 4.dp
    ) {
        Row {
            Image(
                painter = painterResource(id = topic.imageResourceId),
                contentDescription = stringResource(id = topic.nameResourceId),
                contentScale = ContentScale.Crop,
                modifier = modifier
                    .size(width = 68.dp, height = 68.dp)
                    .aspectRatio(1f),
            )
            Box {
                Column {
                    Text(
                        text = stringResource(id = topic.nameResourceId),
                        style = MaterialTheme.typography.body2,
                        modifier = Modifier
                            .padding(
                                start = 16.dp,
                                top = 16.dp,
                                end = 16.dp,
                                bottom = 8.dp
                            )
                    )
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_grain),
                            contentDescription = null,
                            modifier = Modifier
                                .padding(start = 16.dp)
                                .size(12.dp)
                        )
                        Text(
                            text = stringResource(id = topic.coursesCountResourceId),
                            style = MaterialTheme.typography.caption,
                            modifier = Modifier.padding(start = 8.dp)
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
    GridListTheme {
        val topic =
            Topic(R.string.name_photography, R.string.count_photography, R.drawable.photography)
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TopicCard(topic = topic)
        }
    }
}
