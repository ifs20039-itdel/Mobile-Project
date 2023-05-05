package com.example.pampraktikum4_11s20039

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class AnimalsAdapter(
    var context: Context,
    var nameAnimalList: ArrayList<String>,
    var imageAnimalList: ArrayList<Int>
) : BaseAdapter() {

    override fun getCount(): Int {
        return nameAnimalList.size
    }

    override fun getItem(position: Int): Any? {
        return nameAnimalList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View = LayoutInflater.from(parent!!.context).inflate(R.layout.custom_layout, parent, false)
        val tvAnimalName: TextView = view.findViewById(R.id.tvAnimalName)
        val ivAnimalImage: ImageView = view.findViewById(R.id.ivAnimalImage)
        tvAnimalName.text = nameAnimalList[position]
        ivAnimalImage.setImageResource(imageAnimalList[position])
        return view
    }
}
