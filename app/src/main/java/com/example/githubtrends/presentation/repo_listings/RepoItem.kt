package com.example.githubtrends.presentation.repo_listings

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
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
        Row() {

            Image(
                painter = rememberImagePainter(data = repo.owner.avatar),
                contentDescription = null,
                modifier = Modifier.size(72.dp)
            )

            Column() {
                Text(text = repo.owner.owner_name + "/" + repo.name)
                Text(text = repo.description, maxLines = 2)
                Text(text = "" + repo.stars)
            }
        }


    }
}