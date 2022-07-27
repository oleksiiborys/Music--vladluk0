package com.example.core_network.core_network_api.di

import com.example.core_network.core_network_api.data.ArtistsService
import com.example.moduleinjector.BaseApi
import com.google.firebase.auth.FirebaseAuth

interface CoreNetworkApi : BaseApi {
    fun artistsService(): ArtistsService
}