package com.example.pampraktikum6_11s20039

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.ListFragment

class CountriesFragment : ListFragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //Inflate the layout for this fragment
        return  inflater.inflate(R.layout.fragment_countries,
            container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val arrayAdapter = activity?.let {
            ArrayAdapter.createFromResource(
                it, R.array.countries,
                android.R.layout.simple_list_item_1
            )
        }

        listAdapter = arrayAdapter

        listView.setOnItemClickListener { parent, view, position, id ->
            val intent = Intent(activity, SecondActivity::class.java)
            intent.putExtra("position", position)
            startActivity(intent)
        }
    }
}
