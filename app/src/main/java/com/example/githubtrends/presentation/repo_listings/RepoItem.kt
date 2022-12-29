package com.example.githubtrends.presentation.repo_listings

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.githubtrends.data.model.Repo

@Composable
fun RepoItem(
    repo: Repo,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxSize()
            .padding(start = 8.dp, end = 8.dp, bottom = 8.dp),
        backgroundColor = Color.LightGray,
        shape = RoundedCornerShape(4.dp),
    ) {
        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(8.dp)) {

            Image(
                painter = rememberImagePainter(data = repo.owner.avatar),
                contentDescription = null,
                modifier = Modifier
                    .size(88.dp)
                    .padding(end = 8.dp)
            )

            Column() {
                Text(
                    text = repo.owner.owner_name + "/" + repo.name,
                    style = MaterialTheme.typography.h6,
                    modifier = Modifier.padding(bottom = 4.dp)
                )
                Text(
                    text = repo.description,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.padding(bottom = 2.dp)
                )
                Row() {
                    Icon(Icons.Outlined.Star, contentDescription = null)
                    Text(text = "" + repo.stars)
                }
            }
        }


    }
}