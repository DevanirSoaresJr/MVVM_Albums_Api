package devanir.soaresjunior.albumsapirxjavaroommvvmkotlin.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import devanir.soaresjunior.albumsapirxjavaroommvvmkotlin.ui.AlbumsItem
import io.reactivex.Maybe


class AlbumsRepo(private val localDataSource: LocalDataSource,
                 private val remoteDataSource: RemoteDataSource) :DataSource {
    override fun getAlbums(): Maybe<List<AlbumsItem>> {
        return remoteDataSource.getAlbums()
            .doOnSuccess { it.forEach { albums -> addAlbums(albums) } }
            .onErrorResumeNext { _: Throwable -> localDataSource.getAlbums() }
    }

    override fun addAlbums(albums: AlbumsItem) {
        localDataSource.addAlbums(albums)
    }
}
