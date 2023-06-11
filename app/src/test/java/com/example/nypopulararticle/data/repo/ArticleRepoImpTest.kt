package com.example.nypopulararticle.data.repo

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.nypopulararticle.data.remote.api.PopularArticleApi
import com.example.nypopulararticle.data.remote.model.MainResponse
import com.example.nypopulararticle.data.remote.model.article.ArticleRemote
import com.example.nypopulararticle.domain.model.ArticleResponse
import com.example.nypopulararticle.utils.CoroutineTestRule
import com.example.nypopulararticle.utils.MockResponseFileReader
import com.google.common.truth.Truth
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.net.HttpURLConnection

/*
Created by 
Islam Ibrahim
islam.mahmoud116@gmail.com
*/
 class ArticleRepoImpTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    val coroutineTestRule = CoroutineTestRule()

    private var mockWebServer = MockWebServer()
    private lateinit var apiService :PopularArticleApi

    @Before
    fun setUp() {
        apiService = Retrofit.Builder()
            .baseUrl(mockWebServer.url("/"))
            .addConverterFactory(
                GsonConverterFactory.create( GsonBuilder()
                    .setLenient()
                    .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                    .create()))
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build().create(PopularArticleApi::class.java)

    }

    @After
    fun tearDown() {
        mockWebServer.shutdown()
    }

    @Test
    fun `fetch articles response is successful`() {
        val response = MockResponse()
            .setResponseCode(HttpURLConnection.HTTP_OK)
            .setBody(MockResponseFileReader("success_response.json").content)

        mockWebServer.enqueue(response)
        runBlocking(coroutineTestRule.testDispatcher) {
            val articleListResponse: Response<MainResponse<List<ArticleRemote>>> = apiService.mostPopular("1","")
            Truth.assertThat(articleListResponse.isSuccessful).isTrue()
        }
    }

    @Test
    fun `fetch articles response body has desired num_results`() {
        val response = MockResponse()
            .setResponseCode(HttpURLConnection.HTTP_OK)
            .setBody(MockResponseFileReader("success_response.json").content)

        mockWebServer.enqueue(response)
        runBlocking(coroutineTestRule.testDispatcher) {
            val articleListResponse: Response<MainResponse<List<ArticleRemote>>> = apiService.mostPopular("7", "")
            Truth.assertThat(articleListResponse.body()?.numResults).isEqualTo(5)
        }
    }
}