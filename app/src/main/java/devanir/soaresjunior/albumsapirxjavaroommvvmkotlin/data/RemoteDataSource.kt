package devanir.soaresjunior.albumsapirxjavaroommvvmkotlin.data

import devanir.soaresjunior.albumsapirxjavaroommvvmkotlin.net.AlbumsService
import devanir.soaresjunior.albumsapirxjavaroommvvmkotlin.ui.AlbumsItem
import devanir.soaresjunior.albumsapirxjavaroommvvmkotlin.ui.BASE_URL
import io.reactivex.Maybe
import io.reactivex.Observable
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class RemoteDataSource : DataSource {
    override fun addAlbums(album: AlbumsItem) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private val albumsService: AlbumsService by lazy {
        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .build()
        val retrofit = Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
        retrofit.create(AlbumsService::class.java)
    }

    override fun getAlbums(): Maybe<List<AlbumsItem>> {
        return albumsService.getAlbums().flatMap { Maybe.just(it) } }
    }

