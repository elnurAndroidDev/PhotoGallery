package com.isayevapps.photogallery.api

import com.google.gson.annotations.SerializedName

data class PhotoResponse(
    @SerializedName("photo") val galleryItems: List<GalleryItem>
)