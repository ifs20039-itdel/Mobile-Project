package com.example.pampraktikum6_11s20038

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.DialogFragment

class MyDialogFragment : DialogFragment() {

    lateinit var etName: EditText
    lateinit var etAge: EditText
    lateinit var btnCancel: Button
    lateinit var btnOk: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view: View =
            inflater.inflate(R.layout.fragment_my_dialog, container, false)
        etName = view.findViewById(R.id.etName)
        etAge = view.findViewById(R.id.etAge)
        btnOk = view.findViewById(R.id.btnOk)
        btnCancel = view.findViewById(R.id.btnCancel)
        dialog!!.window!!.setBackgroundDrawableResource(android.R.color.transparent)

        btnOk.setOnClickListener {
            val name: String = etName.text.toString()
            val age: Int = etAge.text.toString().toInt()
            val mainActivity: MainActivity = activity as MainActivity
            mainActivity.getUserData (name, age)
            dialog!!.dismiss()
        }
        btnCancel.setOnClickListener {
            dialog!!.dismiss()
        }
        return view
    }
}
