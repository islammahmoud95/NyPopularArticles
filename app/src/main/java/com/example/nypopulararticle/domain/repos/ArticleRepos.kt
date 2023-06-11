package com.example.nypopulararticle.domain.repos

import com.example.nypopulararticle.domain.model.ArticleResponse
import kotlinx.coroutines.flow.Flow

/*
Created by 
Islam Ibrahim
islam.mahmoud116@gmail.com
*/
interface ArticleRepos {
    suspend fun mostPopular (page:String,apiKey:String):Flow<List<ArticleResponse>>
}