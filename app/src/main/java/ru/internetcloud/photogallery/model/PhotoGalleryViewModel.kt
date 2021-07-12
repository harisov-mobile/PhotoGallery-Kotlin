package ru.internetcloud.photogallery.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import ru.internetcloud.photogallery.FlickrFetchr

class PhotoGalleryViewModel: ViewModel() {

    val galleryItemLiveData: LiveData<List<GalleryItem>>

    init {
        galleryItemLiveData = FlickrFetchr().fetchPhotos()
    }
}