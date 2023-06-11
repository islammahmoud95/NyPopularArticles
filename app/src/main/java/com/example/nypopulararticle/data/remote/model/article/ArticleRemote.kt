package com.example.nypopulararticle.data.remote.model.article

import com.google.gson.annotations.SerializedName

/*
Created by 
Islam Ibrahim
islam.mahmoud116@gmail.com
*/
data class ArticleRemote(
    @SerializedName("uri")
    val uri: String? = null,
    @SerializedName("url")
    val url: String? = null,
    @SerializedName("id")
    val id: String? = null,
    @SerializedName("asset_id")
    val assetId: String? = null,
    @SerializedName("source")
    val source: String? = null,
    @SerializedName("published_date")
    val publishedDate: String? = null,
    @SerializedName("updated")
    val updated: String? = null,
    @SerializedName("section")
    val section: String? = null,
    @SerializedName("subsection")
    val subsection: String? = null,
    @SerializedName("nytdsection")
    val nytdsection: String? = null,
    @SerializedName("adx_keywords")
    val adx_keywords: String? = null,
    @SerializedName("column")
    val column: String? = null,
    @SerializedName("byline")
    val byline: String? = null,
    @SerializedName("type")
    val type: String? = null,
    @SerializedName("title")
    val title: String? = null,
    @SerializedName("abstract")
    val abstract: String? = null,
    @SerializedName("des_facet")
    val desFacet: List<String>? = null,
    @SerializedName("geo_facet")
    val geoFacet: List<String>? = null,
    @SerializedName("eta_id")
    val etaId: String? = null,
    @SerializedName("media")
    val media: List<MediaRemote>? = null

)

data class MediaRemote(
    @SerializedName("media-metadata")
    val mediaMetadata: List<MediaMetadataRemote>? = null
)

data class MediaMetadataRemote(
    @SerializedName("url")
    val url: String? = null,
    @SerializedName("height")
    val height: String? = null,
)
