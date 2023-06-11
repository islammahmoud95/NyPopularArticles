package com.example.nypopulararticle.domain.model

import com.google.gson.annotations.SerializedName

/*
Created by 
Islam Ibrahim
islam.mahmoud116@gmail.com
*/
data class ArticleResponse (
    val uri: String? = null,
    val url: String? = null,
    val id: String? = null,
    val assetId: String? = null,
    val source: String? = null,
    val publishedDate: String? = null,
    val updated: String? = null,
    val section: String? = null,
    val subsection: String? = null,
    val nytdsection: String? = null,
    val adx_keywords: String? = null,
    val column: String? = null,
    val byline: String? = null,
    val type: String? = null,
    val title: String? = null,
    val abstract: String? = null,
    val desFacet: List<String>? = null,
    val geoFacet: List<String>? = null,
    val etaId: String? = null,
    val media: List<MediaResponse>? = null
)

data class MediaResponse(
    val mediaMetadata: List<MediaMetadataResponse>? = null
)

data class MediaMetadataResponse(
    val url: String? = null,
    val height: String? = null,
)
