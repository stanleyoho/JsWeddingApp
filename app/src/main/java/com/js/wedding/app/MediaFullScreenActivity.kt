package com.js.wedding.app

import android.os.Bundle
import android.widget.Toast
import com.google.android.youtube.player.YouTubeBaseActivity
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import com.js.wedding.app.Constnats.YOUTUBE_URL
import kotlinx.android.synthetic.main.activity_media_full_screen.*

class MediaFullScreenActivity : YouTubeBaseActivity() , YouTubePlayer.OnInitializedListener{

    private var youtubeString = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_media_full_screen)

        player.initialize(DeveloperKey.DEVELOPER_KEY,this)

        youtubeString = intent?.extras?.getString(YOUTUBE_URL)?:""
    }

    override fun onInitializationFailure(p0: YouTubePlayer.Provider?, p1: YouTubeInitializationResult?) {
        Toast.makeText(this@MediaFullScreenActivity,"load error",Toast.LENGTH_SHORT).show()
    }

    override fun onInitializationSuccess(p0: YouTubePlayer.Provider?, p1: YouTubePlayer?, p2: Boolean) {
        if(!p2){
            p1?.let {
                it.setFullscreen(true)
                it.cueVideo(youtubeString)
            }
        }
    }
}
