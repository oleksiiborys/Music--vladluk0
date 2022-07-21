package com.example.core_network.core_network_api.data

import com.example.music.data.model.artist.Artists
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ArtistsService {
    @Headers(
        "Accept: application/json",
        "Content-Type: application/json",
        "Authorization: Bearer BQC5xi75dC_KI3cRf73r0YZZ3dTzgj537hH8w3KdyVBhhXxlLIAr5zJFmtx1NgPYQNZnojC0U4cUkvDGxEMHuQIiwTI5V1UIG4KmkGscxca0KxohvqSmSSOMxl2Bhx22ysLWQeiyr1d46J6n-ep2vQZmazzH9pk6lw0ZKUElQau8o3kmW3YBhk6ZcgXuwVNmJcBaAGhC",
    )
    @GET("artists/")
    suspend fun fetchArtists(@Query("ids", encoded = true) ids: String): Response<Artists>
}
