package com.example.core_network.core_network_impl.data

import com.example.core_network.core_network_api.data.ArtistsService
import com.example.music.data.model.artist.Artists
import retrofit2.Response

class ArtistsServiceImpl() : ArtistsService {
    override suspend fun fetchArtists(ids: String): Response<Artists> {
        TODO("Not yet implemented")
    }
}