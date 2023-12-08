package com.game.testklassroom2.di

import com.game.testklassroom2.domain.usecase.PostsUseCase
import com.game.testklassroom2.domain.usecase.PostsUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class UseCaseModule {
    @Binds
    abstract fun bindUseCase(impl: PostsUseCaseImpl): PostsUseCase
}