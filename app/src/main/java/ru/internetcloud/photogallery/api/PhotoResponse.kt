package ru.internetcloud.photogallery.api

import com.google.gson.annotations.SerializedName
import ru.internetcloud.photogallery.model.GalleryItem

// PhotoResponse - это массив JSON-объектов "photo"

class PhotoResponse {
    @SerializedName("photo")
    lateinit var galleryItems: List<GalleryItem>
}