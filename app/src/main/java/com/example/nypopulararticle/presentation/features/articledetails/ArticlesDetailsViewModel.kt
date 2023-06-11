package com.example.nypopulararticle.presentation.features.articledetails

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.example.nypopulararticle.core.base.BaseViewModel
import com.example.nypopulararticle.domain.model.ArticleResponse
import com.example.nypopulararticle.domain.usecase.ArticleUseCase
import com.example.nypopulararticle.utils.ARTICLE_DETAILS_OBJECT
import com.example.nypopulararticle.utils.SingleLiveEvent
import com.google.gson.Gson
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

/*
Created by 
Islam Ibrahim
islam.mahmoud116@gmail.com
*/

@HiltViewModel
class ArticlesDetailsViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle
    ) :
    BaseViewModel() {

    val argArticleDetails:String=checkNotNull(savedStateHandle[ARTICLE_DETAILS_OBJECT])
    val mostPopularObserver = SingleLiveEvent<ArticleResponse>()
    val loading = SingleLiveEvent<Boolean>()

    init {
        val articleResponse=Gson().fromJson(argArticleDetails,ArticleResponse::class.java)
        mostPopularObserver.postValue(articleResponse)
    }


}