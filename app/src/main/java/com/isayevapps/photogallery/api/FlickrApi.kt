package com.isayevapps.photogallery.api

import retrofit2.http.GET

private const val API_KEY = "2ae7c55a17c69c160e2882cbc45fbd39"

interface FlickrApi {
    @GET(
        "services/rest/?method=flickr.interestingness.getList" +
                "&api_key=$API_KEY" +
                "&format=json" +
                "&nojsoncallback=1" +
                "&extras=url_s"
    )
    suspend fun fetchPhotos(): FlickrResponse
}