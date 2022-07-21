package com.example.core_network.core_network_impl.di

import com.example.core_network.core_network_api.data.ArtistsService
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class CoreNetworkModule {

    @Provides
    fun provideRetrofit(): Retrofit = Retrofit.Builder()
        .baseUrl("https://api.spotify.com/v1/")
        .client(OkHttpClient())
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Provides
    fun provideArtistService(retrofit: Retrofit): ArtistsService = retrofit.create(ArtistsService::class.java)
}