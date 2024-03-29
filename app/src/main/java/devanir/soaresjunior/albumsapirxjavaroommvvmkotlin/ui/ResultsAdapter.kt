package devanir.soaresjunior.albumsapirxjavaroommvvmkotlin.ui

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import devanir.soaresjunior.albumsapirxjavaroommvvmkotlin.R

class ResultsAdapter: RecyclerView.Adapter<ResultsAdapter.AlbumsViewHolder>() {

    private val albumsList = ArrayList<AlbumsItem>()

    fun setData(albums: List<AlbumsItem>){
        albumsList.clear()
        albumsList.addAll(albums)
        notifyDataSetChanged()
    }

    class AlbumsViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvAlbumId: TextView = view.findViewById(R.id.tvAlbumId)
        val tvAlbumTitle: TextView = view.findViewById(R.id.tvAlbumTitle)
        val tvUserId: TextView = view.findViewById(R.id.tvUserID)

    }

    override fun onCreateViewHolder(p0: ViewGroup, position: Int): ResultsAdapter.AlbumsViewHolder {
        val view = LayoutInflater.from(p0.context).inflate(R.layout.albums_item,p0,false)
        return AlbumsViewHolder(view)
       }

    override fun getItemCount(): Int {
       return albumsList.size
    }

    override fun onBindViewHolder(vh: ResultsAdapter.AlbumsViewHolder, position: Int) {

        val albumsItem = albumsList.get(position)

        val albumId = vh.itemView.context.getString(R.string.strAlbumID, albumsItem.albumId)
        val albumName = vh.itemView.context.getString(R.string.strAlbumName, albumsItem.albumTitle)
        val userId = vh.itemView.context.getString(R.string.strUserID, albumsItem.userId)

        vh.tvAlbumId.text =  albumId
        vh.tvAlbumTitle.text = albumName
        vh.tvUserId.text = userId
    }
}