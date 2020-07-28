package com.example.myapplication

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import kotlinx.android.synthetic.main.main.*

class HomeActivity : Activity() {

    val RC_UPDATE = 10
    private val KEY_NAME = ".sharedPrefName"

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main)

        txt_1.text = loadName()
        btn.text = "Ini button baru nich"

        btn.setOnClickListener {
//            ini function yang dipanggil saat click
            txt_2.text = "Ini abis di klik"

            val intent = Intent(this@HomeActivity, SecondActivity::class.java)
            startActivity(intent)
        }

        btn_update.setOnClickListener{
            val intent = Intent(this, ThirdActivity::class.java)
            intent.putExtra("name", txt_1.text.toString())
            startActivityForResult(intent,RC_UPDATE)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == RC_UPDATE && resultCode == Activity.RESULT_OK) {
            txt_1.text = data?.getStringExtra(("update_name")?: "Unknown data")
            saveName(txt_1.text.toString())
        }
    }

    private fun saveName(name : String) {
        val editor = getAppPref().edit()
        editor.putString(KEY_NAME, name)
        editor.apply()
    }
    private fun loadName() : String = getAppPref().getString(KEY_NAME, "")?: "Unknown name"
    private fun getAppPref() = getSharedPreferences("myapp", Context.MODE_PRIVATE)
}
