package com.example.music.ui.screen.add_artist.paging

//import androidx.paging.PagingSource
//import androidx.paging.PagingState
import com.example.music.data.model.artist.Artist
import com.example.music.data.remote.ArtistsService
import com.example.music.data.remote.RemoteArtistDaraSource
import com.example.music.ui.screen.add_artist.artistsId
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.first

/*class PagingDataSource(
    val backend: RemoteArtistDaraSource,
    val query: String
): PagingSource<Int, Artist>() {
    override fun getRefreshKey(state: PagingState<Int, Artist>): Int? {
        TODO("Not yet implemented")
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Artist> {
       try {
           val nextPageNumber = params.key ?: 1
           val response = backend.searchArtists(artistsId, query)
           return LoadResult.Page(
               data = response.first()
           )
       }
    }
}*/