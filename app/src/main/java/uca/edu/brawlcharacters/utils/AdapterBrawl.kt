package uca.edu.brawlcharacters.utils

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_brawl.view.*
import uca.edu.brawlcharacters.R
import uca.edu.brawlcharacters.model.Brawl

class AdapterBrawl () : RecyclerView.Adapter<AdapterBrawl.ViewHolder>() {

    lateinit var items: ArrayList<Brawl>

    fun setBrawls(items: List<Brawl>){
        this.items = items as ArrayList<Brawl>
        notifyDataSetChanged()
    }

    class ViewHolder (view: View) : RecyclerView.ViewHolder(view) {
        // Holds the TextView that will add each picture to
        val placeImage: ImageView = view.place_image
        val name: TextView = view.name
        val description: TextView = view.description
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_brawl, parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val model= items[position]
        holder.name.text = model.name
        holder.description.text = model.description
        Picasso.get()
                .load(model.image)
                .into(holder.placeImage)
    }

    override fun getItemCount(): Int {
        return if(::items.isInitialized){
            items.size
        }else{
            0
        }
    }
}