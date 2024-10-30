package com.example.blog.di

import android.content.Context
import android.content.SharedPreferences
import com.example.blog.data.datasource.TokenDataSource
import com.example.blog.data.datasource.TokenDataSourceImpl
import com.example.blog.data.network.BlogService
import com.example.blog.data.repository.BlogRepository
import com.example.blog.data.repository.BlogRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    @Singleton
    fun provideSharedPreferences(
        @ApplicationContext context: Context
    ): SharedPreferences {
        return context.getSharedPreferences("app_prefs", Context.MODE_PRIVATE)
    }

    @Provides
    @Singleton
    fun provideBlogRepository(
        blogService: BlogService,
        tokenDataSource: TokenDataSourceImpl
    ): BlogRepository {
        return BlogRepositoryImpl(
            blogService = blogService,
            tokenDataSource = tokenDataSource
        )
    }

    @Provides
    @Singleton
    fun provideTokenDataSource(
        sharedPreferences: SharedPreferences
    ): TokenDataSource {
        return TokenDataSourceImpl(sharedPreferences)
    }
}
