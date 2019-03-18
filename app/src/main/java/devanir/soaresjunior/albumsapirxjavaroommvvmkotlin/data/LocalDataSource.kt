package devanir.soaresjunior.albumsapirxjavaroommvvmkotlin.data

import android.app.Application
import android.arch.persistence.room.Room
import devanir.soaresjunior.albumsapirxjavaroommvvmkotlin.ui.AlbumsItem
import devanir.soaresjunior.albumsapirxjavaroommvvmkotlin.ui.DATABASE_NAME

class LocalDataSource(private val application: Application): DataSource{

    private val database: AlbumsDb by lazy {
        Room.databaseBuilder(application, AlbumsDb::class.java, DATABASE_NAME)
            .build()
    }
    override fun getAlbums()=database.albumsDao().getAllAlbums()

    override fun addAlbums(albums: AlbumsItem) {
database.albumsDao().addAlbums(albums)    }
}