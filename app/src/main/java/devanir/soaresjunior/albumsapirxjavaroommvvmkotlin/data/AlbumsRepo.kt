package devanir.soaresjunior.albumsapirxjavaroommvvmkotlin.data


import devanir.soaresjunior.albumsapirxjavaroommvvmkotlin.ui.AlbumsItem
import io.reactivex.Maybe


class AlbumsRepo(private val localDataSource: LocalDataSource,
                 private val remoteDataSource: RemoteDataSource) :DataSource {
    override fun getAlbums(): Maybe<List<AlbumsItem>> {

        return remoteDataSource.getAlbums()
            .doOnSuccess { it.forEach { albums -> addAlbums(albums) } }
            //onErrorResumeNext is where the magic happens to because if our remoteDataSource fails e.g. No Internet
                //It will get the data from the Database
            .onErrorResumeNext { _: Throwable -> localDataSource.getAlbums() }
    }

    override fun addAlbums(albums: AlbumsItem) {
        localDataSource.addAlbums(albums)
    }
}

