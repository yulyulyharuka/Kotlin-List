package com.example.myapplication

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import kotlinx.android.synthetic.main.third.*

class ThirdActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.third)

        edit_name.setText(intent.getStringExtra("name"?: "Unknown Data"))
        btn_finish.setOnClickListener{
            val newText = edit_name.text.toString()
            val intent = Intent()
            intent.putExtra("update_name", newText)
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
    }
}