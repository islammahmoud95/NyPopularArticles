package com.example.nypopulararticle.data.remote.api

import com.example.nypopulararticle.data.remote.model.MainResponse
import com.example.nypopulararticle.data.remote.model.article.ArticleRemote
import com.example.nypopulararticle.domain.model.ArticleResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

/*
Created by 
Islam Ibrahim
islam.mahmoud116@gmail.com
*/
interface PopularArticleApi {
    @GET("mostpopular/v2/viewed/{page}.json")
    suspend fun mostPopular(
        @Path("page") page:String,
        @Query("api-key") apiKey:String
    ): Response<MainResponse<List<ArticleRemote>>>

}