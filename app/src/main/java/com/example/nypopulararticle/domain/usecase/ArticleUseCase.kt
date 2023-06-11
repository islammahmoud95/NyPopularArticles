package com.example.nypopulararticle.domain.usecase

import com.example.nypopulararticle.domain.model.ArticleResponse
import com.example.nypopulararticle.domain.repos.ArticleRepos
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/*
Created by 
Islam Ibrahim
islam.mahmoud116@gmail.com
*/
class ArticleUseCase @Inject constructor(private val articleRepos: ArticleRepos) {
    suspend fun invoke(
        page: String,
        apiKey: String,
    ): Flow<List<ArticleResponse>> =
        articleRepos.mostPopular(
           page=page,
            apiKey=apiKey
        )
}