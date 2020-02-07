package com.js.wedding.app

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_wedding_video.view.*

class FragmentWeddingVideo : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view =  inflater.inflate(R.layout.fragment_wedding_video, container, false)

        view.text_propose_day.setOnClickListener {
            val intent = Intent(context, MediaFullScreenActivity::class.java)
            intent.putExtra(Constnats.YOUTUBE_URL,"Hq8HPlTVR9I")
            startActivity(intent)
        }

        view.text_propose_show_time.setOnClickListener {
            val intent = Intent(context, MediaFullScreenActivity::class.java)
            intent.putExtra(Constnats.YOUTUBE_URL,"6HmnhHBegaI")
            startActivity(intent)
        }
        return view
    }
}