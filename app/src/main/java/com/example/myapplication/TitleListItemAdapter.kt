package com.example.myapplication

import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TitleListItemAdapter : RecyclerView.Adapter<TitleListItemAdapter.ListItemViewHolder>() {

//    var title = mutableListOf<String>()
//    var description = mutableListOf<String>()

    var listData = mutableListOf<Todo>()


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ListItemViewHolder {
        val viewItem = LayoutInflater.from(parent.context).inflate(R.layout.item_title, null)
        return ListItemViewHolder(viewItem)
    }

    override fun getItemCount(): Int = listData.size

    //    define tampilan data yang harus ditampilin di tiap itemnya
    override fun onBindViewHolder(holder: ListItemViewHolder, position: Int) {
        holder.bindData(listData[position].title, listData[position].description)
    }

    class ListItemViewHolder(val view : View) : RecyclerView.ViewHolder(view) {
        fun bindData(title: String, description: String){
            val txtTitle= view.findViewById<TextView>(R.id.txt_title)
            val txtDesc = view.findViewById<TextView>(R.id.txt_desc)
            txtTitle.setText(title)
            txtDesc.setText(description)
        }
    }

}

open class Todo(var title: String, var description: String) {
}