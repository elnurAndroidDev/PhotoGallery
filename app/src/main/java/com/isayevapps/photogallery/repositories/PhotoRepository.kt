package com.isayevapps.photogallery.repositories

import com.isayevapps.photogallery.api.FlickrApi
import com.isayevapps.photogallery.api.PhotoInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class PhotoRepository {
    private val flickrApi: FlickrApi

    init {
        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(PhotoInterceptor())
            .build()

        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://api.flickr.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()

        flickrApi = retrofit.create()
    }

    suspend fun fetchPhotos() = flickrApi.fetchPhotos().photos.galleryItems
    suspend fun searchPhotos(query: String) = flickrApi.searchPhotos(query).photos.galleryItems
}