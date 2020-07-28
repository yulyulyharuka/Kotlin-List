package com.example.myapplication

import android.app.Activity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.second.*

class SecondActivity :Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second)

        val listItemAdapter = ListItemAdapter()
        rv_list.adapter = listItemAdapter
        rv_list.layoutManager = LinearLayoutManager(this)

        button2.setOnClickListener{
//            Java way
//            val newListItem = listOf("Update 1", "Update 2", "Update 3")
//            listItemAdapter.listItem = newListItem
    //        notify kalo data nya udah berubah
//            listItemAdapter.notifyDataSetChanged()
//            val newListItem = listOf("Update 1", "Update 2", "Update 3")

//            Kotlin way
            listItemAdapter.apply {
                listItem.add("Nama Update")
                notifyDataSetChanged()
            }
        }

    }
}