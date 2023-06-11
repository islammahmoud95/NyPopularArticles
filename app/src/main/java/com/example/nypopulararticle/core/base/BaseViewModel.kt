package com.example.nypopulararticle.core.base

import androidx.lifecycle.ViewModel
import com.example.nypopulararticle.utils.SingleLiveEvent

/*
Created by 
Islam Ibrahim
islam.mahmoud116@gmail.com
*/

abstract class BaseViewModel : ViewModel() {

    var isLoading = SingleLiveEvent<Boolean>()
    fun setIsLoading(boolean: Boolean) {
        isLoading.postValue(boolean)
    }
}