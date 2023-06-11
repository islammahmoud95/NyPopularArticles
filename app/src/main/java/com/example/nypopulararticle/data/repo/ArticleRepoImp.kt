package com.example.nypopulararticle.data.repo

import com.example.nypopulararticle.core.base.BaseRepo
import com.example.nypopulararticle.data.remote.api.PopularArticleApi
import com.example.nypopulararticle.data.remote.mapper.mapToArticleResponse
import com.example.nypopulararticle.domain.model.ArticleResponse
import com.example.nypopulararticle.domain.repos.ArticleRepos
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

/*
Created by 
Islam Ibrahim
islam.mahmoud116@gmail.com
*/
class ArticleRepoImp @Inject constructor(private val articleApi: PopularArticleApi) : ArticleRepos,BaseRepo() {
    override suspend fun mostPopular(page: String, apiKey: String): Flow<List<ArticleResponse>> {
        return flow {
            safeApiCall {
                articleApi.mostPopular(
                    page,apiKey
                )
            }.data?.data?.map { it.mapToArticleResponse() }?.let { emit(it) }
        }
    }

}