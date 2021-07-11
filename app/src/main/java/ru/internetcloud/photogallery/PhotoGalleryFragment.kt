package ru.internetcloud.photogallery

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import ru.internetcloud.photogallery.api.FlickrApi
import ru.internetcloud.photogallery.model.GalleryItem

private const val TAG = "rustam"

class PhotoGalleryFragment: Fragment() {

    // свойства:
    private lateinit var photoRecyclerView: RecyclerView

    // статика:
    companion object {
        fun newInstance() : PhotoGalleryFragment {
            return PhotoGalleryFragment()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.i(TAG, "onCreate")


        val flickrLiveData: LiveData<List<GalleryItem>> = FlickrFetchr().fetchPhotos()

        flickrLiveData.observe(
            this,
            Observer { galleryItems -> Log.d(TAG, "Response received: $galleryItems")}
        )

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_photo_gallery, container, false)

        photoRecyclerView = view.findViewById(R.id.photo_recycler_view)

        photoRecyclerView.layoutManager = GridLayoutManager(context, 3)

        return view
    }
}

