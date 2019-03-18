package devanir.soaresjunior.albumsapirxjavaroommvvmkotlin.ui

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import devanir.soaresjunior.albumsapirxjavaroommvvmkotlin.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val resultsAdapter = ResultsAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvAlbums.layoutManager = LinearLayoutManager(this)
        rvAlbums.adapter = resultsAdapter

        val homeViewModel = ViewModelProviders.of(this).get(HomeVM::class.java)

        val observer = Observer<List<AlbumsItem>> { results->
            if (results != null) {
                resultsAdapter.setData(results)
            }
        }


        homeViewModel.getAlbums(application)
        homeViewModel.getAlbumObservable().observe(this,observer)
    }
}
