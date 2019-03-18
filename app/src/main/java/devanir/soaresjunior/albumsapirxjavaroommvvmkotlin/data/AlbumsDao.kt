package devanir.soaresjunior.albumsapirxjavaroommvvmkotlin.data

import android.arch.persistence.room.*
import devanir.soaresjunior.albumsapirxjavaroommvvmkotlin.ui.AlbumsItem
import io.reactivex.Maybe

@Dao
interface AlbumsDao {
    @Query("SELECT * FROM albums")
    fun getAllAlbums(): Maybe<List<AlbumsItem>>

    @Insert
    fun addAlbums(albums : AlbumsItem)

    @Delete
    fun deleteAlbums(albums : AlbumsItem)

    @Update
    fun updateAlbums(albums: AlbumsItem)
}