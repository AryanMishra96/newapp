package com.example.mistake2.Netwok
import androidx.room.PrimaryKey
import com.example.mistake2.BuildConfig
import com.google.gson.internal.GsonBuildConfig
import retrofit2.http.GET
import android.util.Log
import retrofit2.http.Part
import retrofit2.http.Query
interface ApiService {
    @GET("videos")
    suspend fun getVideos(
      @Query("part") part: String="snippet",
      @Query("chart") chart: String="mostPopular",
      @Query("maxResults") maxResults: Int = 150,
      @Query("key") apikey: String= BuildConfig.YOUTUBE_API_KEY
    ): VideoResponse
    @GET("search")
    suspend fun searchVideos(
        @Query("part") part: String="snippet",
        @Query("q") query:String,
        @Query("maxResults") maxResults:Int = 6,
        @Query("key") apikey: String =BuildConfig.YOUTUBE_API_KEY
    ) :VideoResponse
}
fun getApiKey(): String {
    val apiKey = BuildConfig.YOUTUBE_API_KEY
    Log.d("ApiService", "Using API Key: $apiKey")
    if (apiKey.isBlank()) {
        throw IllegalStateException("API key is missing")
    }
    return apiKey
}
