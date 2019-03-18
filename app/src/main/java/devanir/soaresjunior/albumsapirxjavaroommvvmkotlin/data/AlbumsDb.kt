package devanir.soaresjunior.albumsapirxjavaroommvvmkotlin.data

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import devanir.soaresjunior.albumsapirxjavaroommvvmkotlin.ui.AlbumsItem
import devanir.soaresjunior.albumsapirxjavaroommvvmkotlin.ui.DATABASE_VERSION

@Database(entities = [AlbumsItem::class], version = DATABASE_VERSION)
abstract class AlbumsDb :RoomDatabase() {
    abstract fun albumsDao(): AlbumsDao

}
