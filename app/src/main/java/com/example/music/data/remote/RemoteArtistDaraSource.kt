package com.example.music.data.remote

import android.util.Log
import com.example.music.data.model.artist.Artist
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import javax.inject.Inject

class RemoteArtistDaraSource @Inject constructor(
    private val artistsService: ArtistsService
) {

    /*suspend fun getArtists(artistsId: String): Flow<List<Artist>> {
        return searchArtists(artistsId, "")
    }*/

    /*fun searchArtists(artistsId: String, query: String): Flow<List<Artist>> {
        return flow {

        }
    }*/

    fun searchArtists(artistsId: String, query: String): Flow<List<Artist>> = flow {
        val artists: List<Artist> =
            artistsService.fetchArtists(artistsId).body()?.artists ?: listOf()
        artists.map { artist ->
            artists.filter {
                artist.name.contains(query)
            }
        }
        emit(artists)
    }.flowOn(Dispatchers.IO)
}