package com.example.myapplication

import android.app.Activity
import android.app.TimePickerDialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.home.*
import org.json.JSONObject
import kotlin.reflect.typeOf

class HomeListActivity : Activity() {
    val RC_UPDATE = 10
    val KEY_NAME = ".sharedPrefData"
    val listItemAdapter = TitleListItemAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home)

        var savedData = loadData()

        obj_list.adapter = listItemAdapter
        obj_list.layoutManager = LinearLayoutManager(this)

        btn_add.setOnClickListener{
            val intent = Intent(this@HomeListActivity, EditItemActivity::class.java)
            startActivityForResult(intent,RC_UPDATE)
        }

        if (savedData != null) {
            listItemAdapter.apply {
                for (todo in savedData) {
                    listData.add(todo)
                }
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == RC_UPDATE && resultCode == Activity.RESULT_OK) {
            val newTitle = data?.getStringExtra("new_title")?: ""
            val newDesc = data?.getStringExtra("new_desc")?: ""
            listItemAdapter.apply {
                listData.add(Todo(newTitle, newDesc))
                notifyDataSetChanged()
            }

            saveData(listItemAdapter.listData)
        }
    }

    private fun saveData(listData: MutableList<Todo>) {
        val editor = getAppPref().edit()
        val jsonString = Gson().toJson(listData)
        editor.putString(KEY_NAME, jsonString)
        editor.commit()
    }

    private fun loadData() : MutableList<Todo> {
        val jsonString = getAppPref().getString(KEY_NAME, null)
        val dataType = object : TypeToken<MutableList<Todo>>() {}.type
        var savedData = Gson().fromJson<MutableList<Todo>>(jsonString, dataType)?: mutableListOf<Todo>()
        return savedData
    }

    private fun getAppPref() = getSharedPreferences("myapp", Context.MODE_PRIVATE)
}