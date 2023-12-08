package com.game.testklassroom2.domain.datasource

import com.game.testklassroom2.domain.model.Post
import kotlinx.coroutines.flow.Flow

interface PostsDataSource {

    val flow: Flow<List<Post>>
    suspend fun initialLoadPosts()
    suspend fun loadNextPosts()


}