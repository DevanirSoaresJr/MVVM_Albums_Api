package devanir.soaresjunior.albumsapirxjavaroommvvmkotlin.ui

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.SerializedName


@Entity(tableName = TABLE_NAME)
data class AlbumsItem(
    @PrimaryKey(autoGenerate = false)
    @SerializedName("id")
    val albumId: Int,
    @SerializedName("title")
    val albumTitle: String,
    val userId: Int
)