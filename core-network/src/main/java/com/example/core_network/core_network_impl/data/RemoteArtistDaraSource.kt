package com.example.core_network.core_network_impl.data

import com.example.core_network.core_network_api.data.ArtistsService
import javax.inject.Inject

class RemoteArtistDaraSource @Inject constructor(
    private val artistsService: ArtistsService
) {

    /*fun searchArtists(artistsId: String, query: String): Flow<List<Artist>> = flow {
        val artists: List<Artist> =
            artistsService.fetchArtists(artistsId).body()?.artists ?: listOf()
        artists.map { artist ->
            artists.filter {
                artist.name.contains(query)
            }
        }
        emit(artists)
    }.flowOn(Dispatchers.IO)*/
}