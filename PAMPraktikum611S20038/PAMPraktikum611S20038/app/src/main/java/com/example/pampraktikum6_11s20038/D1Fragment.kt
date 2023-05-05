package com.example.pampraktikum6_11s20038

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

class D1Fragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_d1, container, false)
        val etName: EditText = view.findViewById(R.id.etName)
        val btnSend: Button = view.findViewById(R.id.btnSend)
        btnSend.setOnClickListener {
            val name = etName.text.toString()
            val bundle = Bundle()
            bundle.putString("name", name)
            val d2Fragment = D2Fragment()
            d2Fragment.arguments = bundle
            val fragmentManager: FragmentManager = requireActivity().supportFragmentManager
            val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.flFragment, d2Fragment)
            fragmentTransaction.commit()
        }

        return view
    }
}



