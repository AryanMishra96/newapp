package com.example.mistake2.Netwok

import android.provider.ContactsContract.SearchSnippets

data class VideoResponse (
    val items: List<VideoItem>
)
data class VideoItem(
val kind:String,
    val etag: String,
    val id:String,
    val snippet: Snippet
)
data class Snippet(
    val publishedAt:String,
    val channelId:String,
    val title:String,
    val description:String,
    val thumbnails:Thumbnails,
)
data class Thumbnails(
    val default:Thumbnail,
    val medium:Thumbnail,
    val high:Thumbnail
)
data class Thumbnail (
    val url:String,
    val width:Int,
    val height:Int
)