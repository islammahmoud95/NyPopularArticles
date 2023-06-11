package com.example.nypopulararticle.presentation.features.articales

import androidx.lifecycle.viewModelScope
import com.example.nypopulararticle.BuildConfig.API_KEY
import com.example.nypopulararticle.core.base.BaseViewModel
import com.example.nypopulararticle.domain.model.ArticleResponse
import com.example.nypopulararticle.domain.usecase.ArticleUseCase
import com.example.nypopulararticle.utils.SingleLiveEvent
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
class ArticlesViewModel @Inject constructor(private val articleUseCase: ArticleUseCase) :
    BaseViewModel() {

    val mostPopularObserver = SingleLiveEvent<List<ArticleResponse>>()
    val loading = SingleLiveEvent<Boolean>()

    init {
        getMostPopular()
    }

    fun getMostPopular() {
        viewModelScope.launch {
            loading.postValue(true)
            articleUseCase.invoke(
                "1", API_KEY
            ).catch {
                loading.postValue(false)
                Timber.d("error_msg==${it.message}")
            }.collect {
                loading.postValue(false)
                mostPopularObserver.postValue(it)
            }
        }
    }

}