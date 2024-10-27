package com.example.mistake2.Netwok

import androidx.room.Embedded
import com.google.gson.annotations.SerializedName

data class ShowResponse (
    val id: Int,
    val name:String,
    @SerializedName("_embedded") val embedded: EmbeddedEpisodes
)
data class EmbeddedEpisodes (
val episodes: List<Episode>
)
data class Episode(
    val id:Int,
    val name:String,
    val season:Int,
    val number: Int,
    val videoUrl: String
)