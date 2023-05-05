package com.example.pampraktikum6_11s20039

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class BMIFragment : Fragment() {

    lateinit var tvResult: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view : View =
            inflater.inflate(R.layout.fragment_b_m_i, container, false)
        tvResult = view.findViewById(R.id.tvResult)
        val weight = arguments?.getInt("weight", 0)!!.toInt()
        val height = arguments?.getInt("height", 0)!!.toInt()
        val bmi : Double = ((weight * 10000) / (height * height)).toDouble()
        tvResult.text = "Your BMI is ${bmi}"

        // Inflate the layout for this fragment
        return view
    }
}

