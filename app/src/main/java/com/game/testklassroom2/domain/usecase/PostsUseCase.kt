package com.game.testklassroom2.domain.usecase

import com.game.testklassroom2.domain.datasource.PostsDataSource
import com.game.testklassroom2.domain.model.Post
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PostsUseCaseImpl @Inject constructor(private val postDataSource: PostsDataSource) :
    PostsUseCase {
    override val postFlow: Flow<List<Post>> = postDataSource.flow

    override suspend fun initialLoadPosts() {
        postDataSource.initialLoadPosts()
    }

    override suspend fun loadNextPosts() {
        postDataSource.loadNextPosts()
    }
}

interface PostsUseCase {

    val postFlow: Flow<List<Post>>
    suspend fun initialLoadPosts()

    suspend fun loadNextPosts()

}