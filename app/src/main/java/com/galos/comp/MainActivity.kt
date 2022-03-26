package com.galos.comp

import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.galos.comp.data.PlaceListAdapter
import com.galos.comp.databinding.ActivityMainBinding
import com.galos.comp.model.Place

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private var adapter: PlaceListAdapter? = null
    private var countryList: ArrayList<Place>? = null
    private var layoutManager: RecyclerView.LayoutManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        countryList = ArrayList<Place>()
        layoutManager = LinearLayoutManager(this)
        adapter = PlaceListAdapter(countryList!!, this)

        binding.RecyclerView.layoutManager = layoutManager
        binding.RecyclerView.adapter = adapter

        var countryNameList:Array<String> = arrayOf("Kenya","Uganda","Tanzania","Rwanda","Burundi","Egypt","USA",
            "Uk","Australia","Germany","Ghana","Nigeria","South Sudan","Sudan","Congo","Ethiopia",)
        var citiesNameList:Array<String> = arrayOf("Nairobi","Kampala","Dar El Salam","Kigali","Burundi","Cairo","Washington",
            "London","Toronto","Berlin","Acra","Legos","Juba","Khartoum","Kinshasa","Addis Ababa",)

        for(i in 0..15){
            var place = Place()
            place.CuntryName = countryNameList[i]
            place.CityName = citiesNameList[i]
            countryList?.add(place)
        }
        adapter!!.notifyDataSetChanged()
    }
}