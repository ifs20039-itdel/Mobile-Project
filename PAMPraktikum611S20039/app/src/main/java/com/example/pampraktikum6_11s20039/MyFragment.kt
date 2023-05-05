//package com.example.pampraktikum6_11s20039
//
//import android.os.Bundle
//import androidx.fragment.app.Fragment
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.Button
//import android.widget.EditText
//
//class MyFragment : Fragment() {
//    lateinit var etName : EditText
//    lateinit var etEmail : EditText
//    lateinit var btnSend : Button
//
//
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//
//        val view : View = inflater.inflate(R.layout.fragment_my, container, false)
//        etName = view.findViewById(R.id.etName)
//        etEmail = view.findViewById(R.id.etEmail)
//        btnSend = view.findViewById(R.id.btnSend)
//
//        btnSend.setOnClickListener {
//            val name = etName.text.toString()
//            val email = etEmail.text.toString()
//            (activity as MainActivity).takeData(name, email)
//        }
//
//        return view
//    }
//}
