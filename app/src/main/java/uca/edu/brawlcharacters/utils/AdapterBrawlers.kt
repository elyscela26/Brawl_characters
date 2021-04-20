package uca.edu.brawlcharacters.utils

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_brawler.view.*
import uca.edu.brawlcharacters.R
import uca.edu.brawlcharacters.model.Brawler

class AdapterBrawlers () : RecyclerView.Adapter<AdapterBrawlers.ViewHolder>() {

    lateinit var items: ArrayList<Brawler>

    fun setPlaces(items: List<Brawler>){
        this.items = items as ArrayList<Brawler>
        notifyDataSetChanged()
    }

    class ViewHolder (view: View) : RecyclerView.ViewHolder(view) {
        // Holds the TextView that will add each picture to
        val brawlerImage: ImageView = view.brawler_image
        val name: TextView = view.name
        val descripcion: TextView = view.descripcion
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_brawler, parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val model= items[position]
        holder.name.text = model.name
        holder.descripcion.text = model.descripcion
        Picasso.get()
            .load(model.url)
            .into(holder.brawlerImage)
    }

    override fun getItemCount(): Int {
        return if(::items.isInitialized){
            items.size
        }else{
            0
        }
    }
}