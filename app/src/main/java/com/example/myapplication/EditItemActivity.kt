package com.example.myapplication

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import kotlinx.android.synthetic.main.edit_item.*

class EditItemActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.edit_item)

        btn_save.setOnClickListener {
            val newTitle = edit_title.text.toString()
            val newDesc = edit_desc.text.toString()
            val intent = Intent()
            intent.putExtra("new_title", newTitle)
            intent.putExtra("new_desc", newDesc)
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
    }
}