package com.galos.comp.data

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.galos.comp.R
import com.galos.comp.model.Place

class PlaceListAdapter (private val list:ArrayList<Place>, private val context: Context)
    :RecyclerView.Adapter<PlaceListAdapter.ViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaceListAdapter.ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.card_layout,parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: PlaceListAdapter.ViewHolder, position: Int) {
        holder.bindItem(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bindItem(place: Place){
            var country:TextView = itemView.findViewById(R.id.tvCountry) as TextView
            var city:TextView = itemView.findViewById(R.id.tvCity) as TextView

            country.text = place.CuntryName
            city.text =place.CityName

            itemView.setOnClickListener {
                Toast.makeText(context, country.text, Toast.LENGTH_LONG).show()
            }
        }


    }
}
