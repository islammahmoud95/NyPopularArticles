package com.example.nypopulararticle.data.remote.model

import com.google.gson.annotations.SerializedName

/*
Created by 
Islam Ibrahim
islam.mahmoud116@gmail.com
*/
class MainResponse<T> {
    @SerializedName("results")
    val data: T? = null

    @SerializedName("copyright")
    val copyright: String? = null

    @SerializedName("status")
    val status: String? = null

    @SerializedName("num_results")
    val numResults: Int? = null
}