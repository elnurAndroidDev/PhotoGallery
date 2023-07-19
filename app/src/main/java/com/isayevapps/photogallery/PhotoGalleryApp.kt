package com.isayevapps.photogallery

import android.app.Application
import com.isayevapps.photogallery.repositories.PreferencesRepository

class PhotoGalleryApp: Application() {
    override fun onCreate() {
        super.onCreate()
        PreferencesRepository.initialize(this)
    }
}