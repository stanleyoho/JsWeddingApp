package com.js.wedding.app

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sothree.slidinguppanel.SlidingUpPanelLayout
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_view.view.*

class MainActivity : AppCompatActivity() {

    private lateinit var recycler: RecyclerView
    private lateinit var slidePanel: SlidingUpPanelLayout
    private lateinit var slideLayout: ConstraintLayout
    private lateinit var textDragContent: TextView
    private lateinit var maskView: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recycler = recycler_home
        slidePanel = layout_home_panel
        slideLayout = layout_home_slide_view
        textDragContent = text_drag_content
        maskView = view_mask

        slideLayout.setOnClickListener {
            slidePanel.panelState = SlidingUpPanelLayout.PanelState.HIDDEN
            view_mask.visibility = View.GONE
        }

        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = JSWeddingItemAdapter(this,jsItemCallback)


    }

    private val jsItemCallback = object : JSWeddingItemAdapter.JsItemCallback {
        override fun onClick(type: Int) {
            when(type){
                0->{textDragContent.text = "About Us"}
                1->{textDragContent.text = "Wedding"}
                2->{textDragContent.text = "Video"}
                3->{textDragContent.text = "Place"}
            }
            slidePanel.panelState = SlidingUpPanelLayout.PanelState.COLLAPSED
            view_mask.visibility = View.VISIBLE
        }
    }

    class JSWeddingItemAdapter(private val context:Context,private val itemCallback : JsItemCallback) : RecyclerView.Adapter<RecyclerView.ViewHolder>(){
        private val jsItemArray = arrayOf("About Us","Picture","Video","Place")
        private val jsResArray = arrayOf(R.drawable.bg_about_us,R.drawable.bg_wedding,R.drawable.bg_video,R.drawable.bg_place)

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
            return JSVH(LayoutInflater.from(context).inflate(R.layout.item_view,parent,false))
        }

        override fun getItemCount(): Int {
            return jsItemArray.size
        }

        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
            if(holder is JSVH){
                holder.apply {
                    setItemName(jsItemArray[position])
                    setImage(jsResArray[position])
                    itemView.setOnClickListener { itemCallback.onClick(position) }
                }
            }
        }


        class JSVH(itemView:View) : RecyclerView.ViewHolder(itemView) {
            private var itemName : TextView = itemView.text_item_name
            private var ivItemPic : ImageView = itemView.iv_item_pic

            fun setItemName(name : String){
                itemName.text = name
            }

            fun setImage(resId : Int){
                ivItemPic.setImageResource(resId)
            }

        }

        interface JsItemCallback{
            fun onClick(type : Int)
        }
    }
}
