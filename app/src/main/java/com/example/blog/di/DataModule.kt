package com.example.blog.di

import com.example.blog.data.repository.BlogRepository
import com.example.blog.data.repository.BlogRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {
    @Binds
    fun bindBlogRepository(
        blogRepository: BlogRepositoryImpl
    ): BlogRepository
}
