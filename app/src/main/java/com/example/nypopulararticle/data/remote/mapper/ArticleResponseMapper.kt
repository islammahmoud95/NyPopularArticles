package com.example.nypopulararticle.data.remote.mapper

import com.example.nypopulararticle.data.remote.model.article.ArticleRemote
import com.example.nypopulararticle.data.remote.model.article.MediaMetadataRemote
import com.example.nypopulararticle.data.remote.model.article.MediaRemote
import com.example.nypopulararticle.domain.model.ArticleResponse
import com.example.nypopulararticle.domain.model.MediaMetadataResponse
import com.example.nypopulararticle.domain.model.MediaResponse

/*
Created by 
Islam Ibrahim
islam.mahmoud116@gmail.com
*/


fun ArticleRemote.mapToArticleResponse() = ArticleResponse(
    uri = uri,
    url = url,
    id = id,
    assetId = assetId,
    source = source,
    publishedDate = publishedDate,
    updated = updated,
    section = section,
    subsection = subsection,
    nytdsection = nytdsection,
    adx_keywords = adx_keywords,
    column = column,
    byline = byline,
    type = type,
    title = title,
    abstract = abstract,
    desFacet = desFacet,
    geoFacet = geoFacet,
    etaId = etaId,
    media = media?.map { it.mapToMediaResponse() }
)

fun MediaRemote.mapToMediaResponse() = MediaResponse(
    mediaMetadata = mediaMetadata?.map { it.mapToMediaResponse() }
)

fun MediaMetadataRemote.mapToMediaResponse() = MediaMetadataResponse(
    url = url,
    height = height
)