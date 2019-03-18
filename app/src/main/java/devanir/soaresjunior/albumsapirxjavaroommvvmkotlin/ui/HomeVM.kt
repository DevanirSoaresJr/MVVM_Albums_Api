package devanir.soaresjunior.albumsapirxjavaroommvvmkotlin.ui

import android.app.Application
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import devanir.soaresjunior.albumsapirxjavaroommvvmkotlin.data.AlbumsRepo
import devanir.soaresjunior.albumsapirxjavaroommvvmkotlin.data.DataSource
import devanir.soaresjunior.albumsapirxjavaroommvvmkotlin.data.LocalDataSource
import devanir.soaresjunior.albumsapirxjavaroommvvmkotlin.data.RemoteDataSource
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class HomeVM: ViewModel() {
    private val albumObservable: MutableLiveData<List<AlbumsItem>> = MutableLiveData()

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    fun getAlbumObservable(): LiveData<List<AlbumsItem>> = albumObservable

    private lateinit var repo : DataSource


    fun getAlbums(application: Application){
        repo= AlbumsRepo(remoteDataSource = RemoteDataSource(),
            localDataSource = LocalDataSource(application)
        )

        compositeDisposable.add(repo.getAlbums()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                albumObservable.value= it
            },{
                it.printStackTrace()
            }))

    }
}