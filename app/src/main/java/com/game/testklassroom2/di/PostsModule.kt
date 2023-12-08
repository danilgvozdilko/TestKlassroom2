package com.game.testklassroom2.di

import com.game.testklassroom2.data.datasource.PostsDataSourceImpl
import com.game.testklassroom2.domain.datasource.PostsDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class PostsModule {
    @Binds
    abstract fun bindNetwork(impl: PostsDataSourceImpl): PostsDataSource

}