package com.example.coroutinestoturial01.service

import com.example.coroutinestoturial01.model.part11.Albums
import retrofit2.Response
import retrofit2.http.GET

interface AlbumService {

    /**NOTE: why we use suspend fun? because we are going to use kotlin coroutines with retrofit*/
    @GET("albums")
    suspend fun getAlbums(): Response<Albums>

}