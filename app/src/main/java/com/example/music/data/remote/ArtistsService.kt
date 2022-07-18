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
        "Authorization: Bearer BQA-apn2omHeityUI15Qww4nl95FGONXR8EPpQTI-wU3u5L8mymGHPkFufDM84hqzmR9Db38PoqDq3f_u6URA7g3PV-aGvmb2aYrVQsJbKGLu4_5ls1z3bCzKrxd_uJ8Uiw3vA5df_EEYoy70NHAJlx-pE_kEr7wC1PbZY6COJY0nxbc7mbnB1B6tXGyKxvkRI0-tbg7",
        /*"X-RapidAPI-Host: spotify23.p.rapidapi.com"*/
    )
    @GET("artists/")
    suspend fun fetchArtists(@Query("ids", encoded = true) ids: String): Response<Artists>
}




