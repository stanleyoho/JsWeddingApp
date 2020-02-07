package com.js.wedding.app

import android.app.Application
import android.util.Log
import com.google.firebase.database.*
import com.js.wedding.app.model.WeddingMediaModel

class JsWeddingApplication : Application(){

    override fun onCreate() {
        super.onCreate()

        val database = FirebaseDatabase.getInstance()
        val dbJsMediaReference = database.reference

        dbJsMediaReference.addValueEventListener(object : ValueEventListener{
            override fun onCancelled(p0: DatabaseError) {
                Log.d("reference","onCancelled")
            }

            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot.exists()){
                    for(item in snapshot.children){
                        if(item.key == "jsWeddingMedia"){
                            val type =  object : GenericTypeIndicator<ArrayList<WeddingMediaModel>>(){}
                            val mediaList = item.getValue(type)
                            Log.d("onDataChange","media list : ${mediaList.toString()}")
                        }else{
                            Log.d("onDataChange","media key not match")
                        }
                    }
                }
            }
        })

        dbJsMediaReference.addChildEventListener(object : ChildEventListener{
            override fun onCancelled(p0: DatabaseError) {
                Log.d("addChildEventListener","onCancelled")
            }

            override fun onChildMoved(p0: DataSnapshot, p1: String?) {
                Log.d("addChildEventListener","onChildMoved")
            }

            override fun onChildChanged(p0: DataSnapshot, p1: String?) {
                Log.d("addChildEventListener","onChildChanged")
            }

            override fun onChildAdded(p0: DataSnapshot, p1: String?) {
                Log.d("addChildEventListener","onChildAdded")
            }

            override fun onChildRemoved(p0: DataSnapshot) {
                Log.d("addChildEventListener","onChildRemoved")
            }
        })

    }
}