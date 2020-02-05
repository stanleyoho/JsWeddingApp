package com.js.wedding.app

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_wedding_information.view.*


class FragmentWeddingInfo : Fragment() {
    private lateinit var btnShowMap : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_wedding_information, container, false)
        view.btn_show_map.apply { setOnClickListener{
            val gmmIntentUri: Uri = Uri.parse("geo:0,0?q=白金花園酒店婚宴會館")
            val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
            mapIntent.setPackage("com.google.android.apps.maps")
            startActivity(mapIntent)
            }
        }

        return view
    }
}