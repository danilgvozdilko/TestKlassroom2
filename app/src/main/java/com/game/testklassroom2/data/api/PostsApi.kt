package com.game.testklassroom2.data.api

import com.game.testklassroom2.data.model.PostResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface PostsApi {
    @GET("test")
    suspend fun listPosts(
        @Query("page") page: Int
    ): PostResponse
}