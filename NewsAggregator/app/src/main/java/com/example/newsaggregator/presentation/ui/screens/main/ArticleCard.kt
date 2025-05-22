package com.example.newsaggregator.presentation.ui.screens.main

import android.content.Context
import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.newsaggregator.domain.model.ArticleMainModel

@Composable
fun ArticleCard(
    article: ArticleMainModel,
    context: Context,
    onClick: (String) -> Unit
) {
    Card(
        modifier = Modifier.Companion
            .fillMaxWidth()
            .clickable { onClick.invoke(article.link) },
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(modifier = Modifier.Companion.padding(16.dp)) {
            Row(verticalAlignment = Alignment.Companion.Top) {
                article.imageUrl?.let {
                    AsyncImage(
                        model = ImageRequest.Builder(context)
                            .data(it)
                            .crossfade(true)
                            .listener(
                                onStart = { Log.d("tag", "start") },
                                onSuccess = { _, _ -> Log.d("tag", "success") },
                                onError = { _, r -> Log.d("tag", r.throwable.message.toString()) }
                            )
                            .build(),
                        contentDescription = null,
                        modifier = Modifier.Companion
                            .size(width = 120.dp, height = 90.dp)
                            .clip(RoundedCornerShape(8.dp))
                            .padding(end = 12.dp),
                        contentScale = ContentScale.Companion.Crop
                    )
                }

                Column(modifier = Modifier.Companion.weight(1f)) {
                    Text(
                        text = article.title,
                        style = MaterialTheme.typography.titleMedium
                    )
                }
            }

            Spacer(modifier = Modifier.Companion.height(8.dp))

            Text(
                text = article.description,
                style = MaterialTheme.typography.bodyMedium,
                maxLines = 2,
                overflow = TextOverflow.Companion.Ellipsis,
                modifier = Modifier.Companion.fillMaxWidth()
            )

            Spacer(modifier = Modifier.Companion.height(8.dp))

            Text(
                text = "Tags: " + article.tags.joinToString(", "),
                style = MaterialTheme.typography.labelSmall
            )

            Spacer(modifier = Modifier.Companion.height(2.dp))

            Text(
                text = "By ${article.creator} • ${article.pubDate}",
                style = MaterialTheme.typography.labelMedium
            )
        }
    }
}