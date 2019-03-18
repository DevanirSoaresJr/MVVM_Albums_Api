package devanir.soaresjunior.albumsapirxjavaroommvvmkotlin.net

import devanir.soaresjunior.albumsapirxjavaroommvvmkotlin.ui.AlbumsItem
import devanir.soaresjunior.albumsapirxjavaroommvvmkotlin.ui.ENDPOINT
import io.reactivex.Maybe
import io.reactivex.Observable
import retrofit2.http.GET

interface AlbumsService {
    @GET(ENDPOINT)
    fun getAlbums(): Maybe<List<AlbumsItem>>

}