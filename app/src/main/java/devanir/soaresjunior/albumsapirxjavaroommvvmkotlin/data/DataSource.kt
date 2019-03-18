package devanir.soaresjunior.albumsapirxjavaroommvvmkotlin.data

import devanir.soaresjunior.albumsapirxjavaroommvvmkotlin.ui.AlbumsItem
import io.reactivex.Maybe

interface DataSource {
    fun getAlbums(): Maybe<List<AlbumsItem>>
    fun addAlbums(albums :AlbumsItem)
}