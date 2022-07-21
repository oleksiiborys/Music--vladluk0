package com.example.core_network.core_network_api.di

import com.example.core_network.core_network_api.data.ArtistsService
import com.example.moduleinjector.BaseApi

interface CoreNetworkApi : BaseApi {
    fun artistsService(): ArtistsService
}