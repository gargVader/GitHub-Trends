package com.example.githubtrends.presentation.repo_details

import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberImagePainter
import com.example.githubtrends.R
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState

@Composable
fun RepoDetailsScreen(
    viewModel: RepoDetailsViewModel = hiltViewModel()
) {

    val state = viewModel.state
    val repo = state.repo

    val swipeRefreshState = rememberSwipeRefreshState(isRefreshing = state.isLoading)
    SwipeRefresh(
        state = swipeRefreshState,
        onRefresh = { viewModel.getRepoInfo() }) {

        if (repo == null) {
            Text(text = "Error fetching repo details")
            return@SwipeRefresh
        }

        Column() {


            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = rememberImagePainter(data = repo.owner.avatar),
                    contentDescription = null,
                    modifier = Modifier
                        .size(88.dp)
                        .padding(top = 8.dp, bottom = 8.dp)
                )

                Text(
                    text = repo.owner.owner_name + "/" + repo.name,
                    style = MaterialTheme.typography.h6,
                    modifier = Modifier.padding(bottom = 4.dp)
                )

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(8.dp)
                ) {
                    Icon(
                        imageVector = Icons.Outlined.Star,
                        contentDescription = null,
                        modifier = Modifier.padding(end = 4.dp)
                    )
                    Text(text = "${repo.stars}", modifier = Modifier.padding(end = 8.dp))

                    Icon(
                        painter = painterResource(id = R.drawable.git_fork),
                        modifier = Modifier
                            .size(24.dp)
                            .padding(end = 4.dp),
                        contentDescription = null // decorative element
                    )
                    Text(text = "${repo.forks}")
                }

                Text(
                    text = repo.description,
                    modifier = Modifier.padding(horizontal = 16.dp),
                    textAlign = TextAlign.Center,
                )
            }

            Column(
                modifier = Modifier
                    .fillMaxSize(),
            ) {
                Text(
                    text = "Readme",
                    style = MaterialTheme.typography.h6,
                    modifier = Modifier.padding(top = 32.dp)
                )
                AndroidView(factory = {
                    WebView(it).apply {
                        webViewClient = WebViewClient()

                        loadUrl(repo.url + "/blob/master/README.md")
                    }
                })
            }
        }
    }

}