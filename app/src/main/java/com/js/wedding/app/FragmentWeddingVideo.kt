package com.js.wedding.app

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_wedding_video.view.*
import kotlinx.android.synthetic.main.recycler_media_info_item.view.*

class FragmentWeddingVideo : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view =  inflater.inflate(R.layout.fragment_wedding_video, container, false)

        val recycler = view.media_info_recycler
        recycler.layoutManager = LinearLayoutManager(context)
        recycler.adapter = JSMediaInfoAdapter(context!!)

//        view.text_propose_day.setOnClickListener {
//            val intent = Intent(context, MediaFullScreenActivity::class.java)
//            intent.putExtra(Constnats.YOUTUBE_URL,"Hq8HPlTVR9I")
//            startActivity(intent)
//        }
//
//        view.text_propose_show_time.setOnClickListener {
//            val intent = Intent(context, MediaFullScreenActivity::class.java)
//            intent.putExtra(Constnats.YOUTUBE_URL,"6HmnhHBegaI")
//            startActivity(intent)
//        }
        return view
    }

    class JSMediaInfoAdapter(val context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>(){
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
            return JSMediaVH(LayoutInflater.from(context).inflate(R.layout.recycler_media_info_item,parent,false))
        }

        override fun getItemCount(): Int {
            return InstanceData.jsMediaDataList.size
        }

        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
            if(holder is JSMediaVH){
                val jsVH = holder as JSMediaVH
                val item = InstanceData.jsMediaDataList[position]
                jsVH.itemTitle.text = item.titile
                if(item.islock == "Lock"){
                    jsVH.itemLock.visibility = View.GONE
                    jsVH.itemTitle.setOnClickListener {
                        val intent = Intent(context, MediaFullScreenActivity::class.java)
                        intent.putExtra(Constnats.YOUTUBE_URL,item.url)
                        context.startActivity(intent)
                    }
                }else{
                    jsVH.itemLock.visibility = View.VISIBLE
                }
            }
        }

        class JSMediaVH(itemView : View) : RecyclerView.ViewHolder(itemView){
            val itemTitle = itemView.text_media_info_item
            val itemLock = itemView.iv_media_info_item
        }
    }
}