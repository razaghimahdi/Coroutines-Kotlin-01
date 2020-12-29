package com.example.coroutinestoturial01.service

import com.example.coroutinestoturial01.model.part11.Albums
import com.example.coroutinestoturial01.model.part11.AlbumsItem
import retrofit2.Response
import retrofit2.http.*

interface AlbumService {

    /**NOTE: why we use suspend fun? because we are going to use kotlin coroutines with retrofit*/
    @GET("albums")
    suspend fun getAlbums(): Response<Albums>

    @GET("albums")
    suspend fun getSortedAlbums(@Query("userId") userId: Int): Response<Albums>


    @GET("albums/{id}")
    suspend fun getAlbum(@Path(value = "id") albumId:Int): Response<AlbumsItem>

    @POST("albums")
    suspend fun uploadAlbum(@Body album:AlbumsItem): Response<AlbumsItem>




}