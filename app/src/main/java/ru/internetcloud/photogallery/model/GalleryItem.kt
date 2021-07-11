package ru.internetcloud.photogallery.model

import com.google.gson.annotations.SerializedName

data class GalleryItem(
    var title: String = "",
    var id: String = "",

    @SerializedName("url_s") // у нас свойство называется "url",
    // а в JSON-данных, возвращаемых с сервера - "url_s"
    var url: String = ""
)