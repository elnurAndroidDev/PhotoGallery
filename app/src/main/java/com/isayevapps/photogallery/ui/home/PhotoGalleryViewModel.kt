package com.isayevapps.photogallery.ui.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.isayevapps.photogallery.api.GalleryItem
import com.isayevapps.photogallery.repository.PhotoRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class PhotoGalleryViewModel : ViewModel() {
    private val repository = PhotoRepository()

    private val _galleryItems: MutableStateFlow<List<GalleryItem>> = MutableStateFlow(emptyList())
    val galleryItems: StateFlow<List<GalleryItem>>
        get() = _galleryItems.asStateFlow()

    init {
        viewModelScope.launch {
            try {
                val items = PhotoRepository().fetchPhotos()
                Log.d("MyTaggg", "Items received: $items")
                _galleryItems.value = items
            } catch (e: Exception) {
                Log.d("MyTaggg", "Ooops! ${e.message.toString()}")
            }
        }
    }
}