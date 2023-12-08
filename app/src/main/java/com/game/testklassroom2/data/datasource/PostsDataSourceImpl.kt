package com.game.testklassroom2.data.datasource

import com.game.testklassroom2.data.api.PostsApi
import com.game.testklassroom2.data.mapping.toDomain
import com.game.testklassroom2.data.model.PostResponse
import com.game.testklassroom2.domain.datasource.PostsDataSource
import com.game.testklassroom2.domain.model.Post
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject


class PostsDataSourceImpl @Inject constructor(
    private val postApi: PostsApi
) : PostsDataSource {
    private var page = 1
    private var totalItems = 0

    private val _postsFlow = MutableStateFlow<List<Post>>(emptyList()) // store domaunt Post
    override val flow: Flow<List<Post>> = _postsFlow.asStateFlow()

    override suspend fun initialLoadPosts() {
        page = 1
        totalItems = 0
        val response = postApi.listPosts(page)
        totalItems = response.total_pages ?: 0
        updateList(response)
    }

    private fun updateList(response: PostResponse) {
        _postsFlow.update {
            ArrayList(it).apply {
                addAll(
                    response.posts
                        .map { it.toDomain() }
                        .filterNotNull()
                        ?: emptyList()
                )
            }
        }
    }

    override suspend fun loadNextPosts() {
        page++
        postApi.listPosts(page)
        val response = postApi.listPosts(page)
        totalItems = response.total_pages ?: 0
        updateList(response)
    }

}