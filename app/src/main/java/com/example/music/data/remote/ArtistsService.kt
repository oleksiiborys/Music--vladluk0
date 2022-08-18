package com.example.music.data.remote

import com.example.music.data.model.artist.Artists
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

/*interface ArtistsService {
    @Headers(
        "X-RapidAPI-Key: 18e41a160amsh1fdbd34e757ce8dp1e6c22jsn0b8cf7a18a1f",
        "X-RapidAPI-Host: spotify23.p.rapidapi.com"
    )
    @GET("artists/")
    suspend fun fetchArtists(@Query("ids", encoded = true) ids: String): Response<Artists>
}*/

interface ArtistsService {
    @Headers(
        "Accept: application/json",
        "Content-Type: application/json",
        "Authorization: Bearer BQClUjICqD6IHWf961WljD6Kw_E7qFGDNhgsxyjvoj4xDicD6K8Nds4X9sNqY__Nh8FqNa5nCjao_8WuppsMo9iq3Jd0hpZqyuIegdZp8Jg_YJahrF7nw50QzDHjZXtZ4YUs6qQCj7sIUZSM4mAiV1edUazRvEVhxVKMtgodOGWEhbUz1RAn0Z4uuJ0Ahr1sIrJCjkyz",
        /*"X-RapidAPI-Host: spotify23.p.rapidapi.com"*/
    )
    @GET("artists/")
    suspend fun fetchArtists(@Query("ids", encoded = true) ids: String): Response<Artists>
}




