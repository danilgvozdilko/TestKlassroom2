package com.game.testklassroom2.data.model

data class PostResponse(
    val page: Int?,
    val posts: List<PostDto>,
    val total_pages: Int?
)