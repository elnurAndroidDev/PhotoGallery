package com.isayevapps.photogallery.ui.home

import com.isayevapps.photogallery.api.GalleryItem

data class PhotoGalleryUiState(
    val images: List<GalleryItem> = listOf(),
    val query: String = "",
)
