package com.example.pampraktikum6_11s20039

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView

class DetailCountryFragment : Fragment() {

    private var ivFlag: ImageView? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_detail_country, container, false)
        ivFlag = view.findViewById(R.id.ivFlag)
        val position = arguments?.getInt("position", 0)

        when (position) {
            0 -> ivFlag?.setImageResource(R.drawable.indonesia)
            1 -> ivFlag?.setImageResource(R.drawable.malaysia)
            2 -> ivFlag?.setImageResource(R.drawable.singapura)
            3 -> ivFlag?.setImageResource(R.drawable.thailand)
            4 -> ivFlag?.setImageResource(R.drawable.vietnam)
        }

        return view
    }
}
