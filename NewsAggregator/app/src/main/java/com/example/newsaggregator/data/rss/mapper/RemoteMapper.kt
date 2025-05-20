package com.example.newsaggregator.data.rss.mapper

import com.example.newsaggregator.data.rss.dto.ItemDto
import com.example.newsaggregator.domain.model.ArticleMainModel

fun ItemDto.toArticleMainModel(): ArticleMainModel {
    return ArticleMainModel(
        title = this.title,
        link = this.link,
        description = this.description,
        tags = this.categories.map { it.value },
        pubDate = this.pubDate,
        imageUrl = this.contents.first().url,
        creator = this.dcCreator,
        date = this.dcDate
    )
}