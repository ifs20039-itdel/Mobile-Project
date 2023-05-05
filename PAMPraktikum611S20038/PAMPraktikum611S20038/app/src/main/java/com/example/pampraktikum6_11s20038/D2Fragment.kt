package com.example.pampraktikum6_11s20038

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class D2Fragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(
            R.layout.fragment_d2,
            container, false
        )
        val tvName: TextView = view.findViewById(R.id.tvName)
        tvName.text = arguments?.getString("name").toString()
        // Inflate the layout for this fragment
        return view
    }
}

