package com.example.nypopulararticle.data.di

import com.example.nypopulararticle.data.remote.api.PopularArticleApi
import com.example.nypopulararticle.data.repo.ArticleRepoImp
import com.example.nypopulararticle.domain.repos.ArticleRepos
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

/*
Created by
Islam Ibrahim
islam.mahmoud116@gmail.com
*/
@Module(includes = [ArticleDataModule.BindsModule::class])
@InstallIn(SingletonComponent::class)
object ArticleDataModule {

    @Provides
    @Singleton
    fun provideConfigApi(
        retrofit: Retrofit
    ): PopularArticleApi {
        return retrofit.create(PopularArticleApi::class.java)
    }

    @Module
    @InstallIn(SingletonComponent::class)
    interface BindsModule {

        @Binds
        @Singleton
        fun bindArticleRepos(impl: ArticleRepoImp): ArticleRepos
    }

}